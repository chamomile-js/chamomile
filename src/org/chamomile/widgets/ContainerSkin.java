package org.chamomile.widgets;

import org.chamomile.collections.Sequence;
import org.w3c.dom.html.HTMLElement;

public abstract class ContainerSkin<T extends View> extends ComponentSkin implements ViewParentListener<T> {

	@Override
	public void install(Component component) {
		super.install(component);

		@SuppressWarnings("unchecked")
		Container<T> container = (Container<T>) component;

		// Add this as a container listener
		container.getContainerListeners().add(this);

		//
		// Install property change listeners.
		//

	}

	@Override
	public void viewInserted(ViewParent<T> container, int index) {
		HTMLElement parentElem = getContainerElement();
		Component component = container.getChildren().get(index).toComponent();
		if (component != null) {
			HTMLElement newElem = component.getSkin().getElement();
			if (++index >= container.getChildren().getLength()) {
				parentElem.appendChild(newElem);
			} else {
				Skin skin = getSkin(container.getChildren().get(index));
				parentElem.insertBefore(newElem, skin.getElement());
			}
		}
	}

	@Override
	public void viewsRemoved(ViewParent<T> container, int index, Sequence<T> removed) {
		HTMLElement parentElem = getContainerElement();
		for (int i = 0, n = removed.getLength(); i < n; i++) {
			Component component = removed.get(i).toComponent();
			if (component != null) {
				HTMLElement elem = component.getSkin().getElement();
				parentElem.removeChild(elem);
			}
		}
	}

	@Override
	public void viewMoved(ViewParent<T> container, int from, int to) {
		throw new UnsupportedOperationException("Not implemented yet!!!");
	}

	protected abstract HTMLElement getContainerElement();

}
