package org.chamomile.widgets;

import org.chamomile.collections.Sequence;

import j2js.w3c.dom.NodeList;
import j2js.w3c.dom.html.HTMLElement;

public abstract class ContainerSkin<T extends Component> extends ComponentSkin implements ContainerListener<T> {

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
	public void viewInserted(Container<T> container, int index) {
		HTMLElement parentElem = getContainerElement();
		Component component = container.getChildren().get(index);
		if (component != null) {
			HTMLElement newElem = component.getSkin().getElement();
			if (index >= parentElem.getChildElementCount()) {
				parentElem.appendChild(newElem);
			} else {
				NodeList childNodes = parentElem.getChildNodes();
				parentElem.insertBefore(newElem, childNodes.item(index));
			}
		}
	}

	@Override
	public void viewRemoved(Container<T> container, int index, Sequence<T> removed) {
		HTMLElement parentElem = getContainerElement();
		for (int i = 0, n = removed.getLength(); i < n; i++) {
			Component component = removed.get(i);
			if (component != null) {
				HTMLElement elem = component.getSkin().getElement();
				parentElem.removeChild(elem);
			}
		}
	}

	@Override
	public void viewMoved(Container<T> container, int from, int to) {
		throw new UnsupportedOperationException("Not implemented yet!!!");
	}
	
	protected abstract HTMLElement getContainerElement();

}