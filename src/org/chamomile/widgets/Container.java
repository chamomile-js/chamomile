package org.chamomile.widgets;

import java.util.ArrayList;

import org.chamomile.collections.Sequence;
import org.chamomile.util.InternalPreconditions;
import org.chamomile.util.ListenerList;

public abstract class Container<T extends Component> extends Component implements HasChildren<T> {

	public final class ChildrenSequence implements Sequence<T> {
		private final Sequence<T> children = Sequence.create(new ArrayList<T>());

		@Override
		public int add(T child) {
			int index = getLength();
			insert(child, index);
			return index;
		}

		@Override
		public void insert(T child, int index) {
			InternalPreconditions.checkArgument(child != null, "child is null");
			InternalPreconditions.checkArgument(!contains(child), "child '%s' was added before", child);
			InternalPreconditions.checkArgument(child.getParent() == null, "child '%s' already has a parent.", child);

			if (child instanceof HasChildren && ((HasChildren<?>) child).isAncestor(Container.this)) {
				throw new IllegalArgumentException("Component already exists in ancestry.");
			}

			child.setParent(Container.this);
			children.insert(child, index);
			if (containerListeners != null) {
				containerListeners.componentInserted(Container.this, index);
			}
		}

		public boolean contains(T child) {
			return children.indexOf(child) != -1;
		}

		@Override
		public T update(int index, T child) {
			throw new UnsupportedOperationException();
		}

		@Override
		public int remove(T child) {
			int index = children.indexOf(child);
			if (index > -1) {
				remove(index, 1);
			}
			return index;
		}

		@Override
		public Sequence<T> remove(int index, int count) {
			Sequence<T> removed = children.remove(index, count);
			if (removed.getLength() > 0) {
				if (containerListeners != null) {
					containerListeners.componentsRemoved(Container.this, index, removed);
				}
			}
			return removed;
		}

		@Override
		public T get(int index) {
			return children.get(index);
		}

		@Override
		public int indexOf(T item) {
			return children.indexOf(item);
		}

		@Override
		public int getLength() {
			return children.getLength();
		}

		@Override
		public void clear() {
			remove(0, getLength());
		}
	}

	// ---

	private HasChildrenListenerList<T> containerListeners;

	/**
	 * The container's children property.
	 */
	public static final String CHILDREN = "_children";

	@Override
	@SuppressWarnings("unchecked")
	public ChildrenSequence getChildren() {
		ChildrenSequence children = (ChildrenSequence) get(CHILDREN);
		if (children == null) {
			put(CHILDREN, children = new ChildrenSequence(), null);
		}
		return children;
	}

	// ---

	@Override
	public boolean isAncestor(HasChildren<?> container) {
		boolean ancestor = false;

		Component parent = (Component) container;
		while (parent != null) {
			if (parent == this) {
				ancestor = true;
				break;
			}
			parent = (Component) parent.getParent();
		}

		return ancestor;
	}

	@Override
	public void descendantAdded(Component descendant) {
		HasChildren<?> parent = getParent();

		if (parent != null) {
			parent.descendantAdded(descendant);
		}
	}

	@Override
	public void descendantRemoved(Component descendant) {
		HasChildren<?> parent = getParent();

		if (parent != null) {
			parent.descendantRemoved(descendant);
		}
	}

	public final ListenerList<HasChildrenListener<T>> getContainerListeners() {
		if (containerListeners == null) {
			containerListeners = new HasChildrenListenerList<T>();
		}
		return containerListeners;
	}
}
