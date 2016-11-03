package org.chamomile.widgets;

import java.util.ArrayList;

import org.chamomile.collections.Sequence;
import org.chamomile.util.InternalPreconditions;
import org.chamomile.util.ListenerList;
import org.chamomile.widgets.skin.DefaultFieldSetSkin;
import org.chamomile.widgets.skin.FieldSetSkin;

public class FieldSet extends FormGroup implements HasChildren<FormGroup> {

	public final class ChildrenSequence implements Sequence<FormGroup> {
		private final Sequence<FormGroup> children = Sequence.create(new ArrayList<FormGroup>());

		@Override
		public int add(FormGroup child) {
			int index = getLength();
			insert(child, index);
			return index;
		}

		@Override
		public void insert(FormGroup child, int index) {
			InternalPreconditions.checkArgument(child != null, "child is null");
			InternalPreconditions.checkArgument(!contains(child), "child '%s' was added before", child);
			InternalPreconditions.checkArgument(child.getParent() == null, "child '%s' already has a parent.", child);

			if (child instanceof HasChildren && ((HasChildren<?>) child).isAncestor(FieldSet.this)) {
				throw new IllegalArgumentException("Component already exists in ancestry.");
			}

			child.setParent(FieldSet.this);
			children.insert(child, index);
			if (fieldSetListeners != null) {
				fieldSetListeners.componentInserted(FieldSet.this, index);
			}
		}

		public boolean contains(FormGroup child) {
			return children.indexOf(child) != -1;
		}

		@Override
		public FormGroup update(int index, FormGroup child) {
			throw new UnsupportedOperationException();
		}

		@Override
		public int remove(FormGroup child) {
			int index = children.indexOf(child);
			if (index > -1) {
				remove(index, 1);
			}
			return index;
		}

		@Override
		public Sequence<FormGroup> remove(int index, int count) {
			Sequence<FormGroup> removed = children.remove(index, count);
			if (removed.getLength() > 0) {
				if (fieldSetListeners != null) {
					fieldSetListeners.componentsRemoved(FieldSet.this, index, removed);
				}
			}
			return removed;
		}

		@Override
		public FormGroup get(int index) {
			return children.get(index);
		}

		@Override
		public int indexOf(FormGroup item) {
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

	private HasChildrenListenerList<FormGroup> fieldSetListeners;

	public FieldSet() {
		this(new DefaultFieldSetSkin());
	}

	public FieldSet(FieldSetSkin skin) {
		setSkin(skin);
	}

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

	/**
	 * The field set's legend property.
	 */
	public static final String LEGEND = "legend";

	public String getLegend() {
		return (String) get(LEGEND, "");
	}

	public void setLegend(String legend) {
		put(LEGEND, legend);
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

	// ---

	public final ListenerList<HasChildrenListener<FormGroup>> getFieldSetListeners() {
		if (fieldSetListeners == null) {
			fieldSetListeners = new HasChildrenListenerList<FormGroup>();
		}
		return fieldSetListeners;
	}
}
