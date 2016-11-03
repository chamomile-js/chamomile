package org.chamomile.widgets;

import java.util.ArrayList;

import org.chamomile.beans.ObservableBean;
import org.chamomile.collections.Sequence;
import org.chamomile.util.Callback;
import org.chamomile.util.InternalPreconditions;
import org.chamomile.util.ListenerList;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventException;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;

public abstract class Component extends ObservableBean implements EventTarget {

	public final class ClassNameSequence implements Sequence<String> {
		private final Sequence<String> classNames = Sequence.create(new ArrayList<String>());

		@Override
		public int add(String className) {
			int index = getLength();
			insert(className, index);
			return index;
		}

		@Override
		public void insert(String className, int index) {
			InternalPreconditions.checkArgument(className != null, "className is null");
			InternalPreconditions.checkArgument(!contains(className), "className '%s' was added before", className);
			classNames.insert(className, index);
			classNameListeners.classNameInserted(Component.this, index);
		}

		@Override
		public String update(int index, String item) {
			throw new UnsupportedOperationException();
		}

		@Override
		public int remove(String className) {
			int index = indexOf(className);
			if (index != -1) {
				remove(index, 1);
			}
			return index;
		}

		@Override
		public Sequence<String> remove(int index, int count) {
			Sequence<String> removed = classNames.remove(index, count);
			if (count > 0) {
				classNameListeners.classNamesRemoved(Component.this, index, classNames);
			}
			return removed;
		}

		@Override
		public String get(int index) {
			return classNames.get(index);
		}

		@Override
		public int indexOf(String className) {
			return classNames.indexOf(className);
		}

		public boolean contains(String className) {
			return classNames.indexOf(className) != -1;
		}

		@Override
		public int getLength() {
			return classNames.getLength();
		}

		@Override
		public void clear() {
			remove(0, getLength());
		}
	}

	private final class ClassNameListenerList extends ListenerList<ClassNameListener>
			implements ClassNameListener {

		@Override
		public void classNameInserted(Component component, int index) {
			for (ClassNameListener listener : this) {
				listener.classNameInserted(Component.this, index);
			}
		}

		@Override
		public void classNamesRemoved(Component component, int index, Sequence<String> classNames) {
			for (ClassNameListener listener : this) {
				listener.classNamesRemoved(Component.this, index, classNames);
			}
		}
	}

	// ---

	private final ClassNameListenerList classNameListeners = new ClassNameListenerList();

	private Skin skin = null;

	protected Skin getSkin() {
		return skin;
	}

	protected void setSkin(Skin skin) {
		if (skin == null) {
			throw new IllegalArgumentException("Skin is null");
		}
		
		if (this.skin != null) {
			throw new IllegalArgumentException("Skin already set");
		}
		
		this.skin = skin;
		
		// Associate the renderer with this component...
		this.skin.install(this);
	}

	/**
	 * The component's id property.
	 */
	public static final String ID = "id";

	public String getId() {
		return (String) get(ID);
	}

	public void setId(String id) {
		put(ID, id);
	}
	
	/**
	 * The component's classNames property.
	 */
	public static final String CLASS_NAMES = "_classNames";
	
	public ClassNameSequence getClassNames() {
		ClassNameSequence classNames = (ClassNameSequence) get(CLASS_NAMES);
		if (classNames == null) {
			put(CLASS_NAMES, classNames = new ClassNameSequence(), null);
		}
		return classNames;
	}

	/**
	 * The parent view, or {@code null} if the view does not have a parent.
	 * <p>
	 * Visibility: {@code protected}.
	 */
	public static final String PARENT = "_parent";

	public HasChildren<?> getParent() {
		return (HasChildren<?>) get(PARENT);
	}

	protected void setParent(final HasChildren<?> parent) {
		HasChildren<?> previousParent = (HasChildren<?>) get(PARENT);
		if (previousParent != null) {
			previousParent.descendantRemoved(this);
		}
		put(PARENT, parent, new Callback<HasChildren<?>, Void>() {
			@Override
			public Void call(HasChildren<?> previousValue) {
				if (parent != null) {
					parent.descendantAdded(Component.this);
				}
				return null;
			}
		});
	}

	//
	// EventTarget interface implementation.
	//

	@Override
	public void addEventListener(String type, EventListener listener, boolean useCapture) {
		EventTarget eventTarget = (EventTarget) getSkin().getActiveElement();
		eventTarget.addEventListener(type, listener, useCapture);
	}

	@Override
	public void removeEventListener(String type, EventListener listener, boolean useCapture) {
		EventTarget eventTarget = (EventTarget) getSkin().getActiveElement();
		eventTarget.removeEventListener(type, listener, useCapture);
	}

	@Override
	public boolean dispatchEvent(Event evt) throws EventException {
		EventTarget eventTarget = (EventTarget) getSkin().getActiveElement();
		return eventTarget.dispatchEvent(evt);
	}

	//
	// Component listeners.
	//

	public ListenerList<ClassNameListener> getComponentStyleNameListeners() {
		return classNameListeners;
	}

}
