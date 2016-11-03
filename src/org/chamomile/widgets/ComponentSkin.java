package org.chamomile.widgets;

import org.chamomile.beans.BeanListener;
import org.chamomile.beans.ObservableBean;
import org.chamomile.collections.Dictionary;
import org.chamomile.collections.Sequence;
import org.chamomile.util.Callback;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.html.HTMLElement;

public abstract class ComponentSkin implements Skin, BeanListener, ClassNameListener {

	protected final Dictionary<String, Callback<? extends Object, Void>> propertyChangeHandlers = Dictionary.create();

	private Component component = null;

	// --- Basic functionality ---------------------------------------------

	@Override
	public void install(Component component) {
		if (this.component != null) {
			// throw new IllegalStateException("Skin already installed on a
			// view");
		}

		this.component = component;
		this.component.getBeanListeners().add(this);
		this.component.getComponentStyleNameListeners().add(this);

		//
		// Install property change listeners.
		//

		propertyChangeHandlers.put(Component.ID, new Callback<String, Void>() {
			@Override
			public Void call(String previousValue) {
				idChanged(getComponent(), previousValue);
				return null;
			}
		});

		propertyChangeHandlers.put(Component.PARENT, new Callback<Container<?>, Void>() {
			@Override
			public Void call(Container<?> value) {
				parentChanged(getComponent(), value);
				return null;
			}
		});
	}

	protected void idChanged(Component component, String previousValue) {
		getActiveElement().setId(component.getId());
	}

	protected Void parentChanged(Component component, Container<?> previousValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Component getComponent() {
		return component;
	}

	protected static Skin getSkin(Component component) {
		return component.getSkin();
	}

	@Override
	public final void propertyChanged(ObservableBean bean, String property, Object previousValue) {
		@SuppressWarnings("unchecked")
		Callback<Object, Void> listener = (Callback<Object, Void>) propertyChangeHandlers.get(property);
		if (listener != null) {
			listener.call(previousValue);
		}
	}

	@Override
	public int getOffsetTop() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getOffsetLeft() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getOffsetWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getOffsetHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	// --- ComponentStyleNameListener --------------------------------------

	@Override
	public void classNameInserted(Component component, int index) {
		setClassName(component.getClassNames().get(index), true);
	}

	@Override
	public void classNamesRemoved(Component component, int index, Sequence<String> classNames) {
		for (int i = 0, n = classNames.getLength(); i < n; i++) {
			setClassName(classNames.get(i), false);
		}
	}

	// --- Helpers ---------------------------------------------------------

	private static final String[] browserSupport = { "webkit", "moz", "ms" };

	protected void setCustomStyle(CSSStyleDeclaration style, String propertyName, String value, String priority) {
		String _propertyName = capitalize(propertyName);
		for (String prefix : browserSupport) {
			style.setProperty(prefix + _propertyName, value, priority);
		}
		style.setProperty(propertyName, value, priority);
	}

	private static String capitalize(String s) {
		if (s.length() == 0)
			return s;
		return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
	}

	private void setClassName(String className, boolean add) {
		HTMLElement elem = getElement();
		if (add) {
			addClassName(elem, elem.getClassName(), className);
		} else {
			removeClassName(elem, elem.getClassName(), className);
		}
	}

	/**
	 * Adds a name to this element's class property. If the name is already
	 * present, this method has no effect.
	 */
	public final boolean addClassName(HTMLElement elem, String oldClassName, String className) {
		// Get the current style string.
		int idx = indexOfName(oldClassName, className);

		// Only add the style if it's not already present.
		if (idx == -1) {
			if (oldClassName.length() > 0) {
				elem.setClassName(oldClassName + " " + className);
			} else {
				elem.setClassName(className);
			}
			return true;
		}
		return false;
	}

	/**
	 * Removes a name from this element's class property. If the name is not
	 * present, this method has no effect.
	 */
	public final boolean removeClassName(HTMLElement elem, String oldClassName, String className) {
		// Get the current style string.
		int idx = indexOfName(oldClassName, className);

		// Don't try to remove the style if it's not there.
		if (idx != -1) {
			// Get the leading and trailing parts, without the removed name.
			String begin = oldClassName.substring(0, idx).trim();
			String end = oldClassName.substring(idx + className.length()).trim();

			// Make sure we don't leave extra spaces.
			String newClassName;
			if (begin.length() == 0) {
				newClassName = end;
			} else if (end.length() == 0) {
				newClassName = begin;
			} else {
				newClassName = begin + " " + end;
			}

			elem.setClassName(newClassName);
			return true;
		}
		return false;
	}

	/**
	 * Returns the index of the first occurrence of name in a space-separated
	 * list of names, or -1 if not found.
	 *
	 * @param nameList
	 *            list of space delimited names
	 * @param name
	 *            a non-empty string. Should be already trimmed.
	 */
	private static int indexOfName(String nameList, String name) {
		int idx = nameList.indexOf(name);

		// Calculate matching index.
		while (idx != -1) {
			if (idx == 0 || nameList.charAt(idx - 1) == ' ') {
				int last = idx + name.length();
				int lastPos = nameList.length();
				if ((last == lastPos)
						|| ((last < lastPos) && (nameList.charAt(last) == ' '))) {
					break;
				}
			}
			idx = nameList.indexOf(name, idx + 1);
		}

		return idx;
	}
}
