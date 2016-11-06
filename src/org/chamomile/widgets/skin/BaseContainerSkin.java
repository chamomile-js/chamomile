package org.chamomile.widgets.skin;

import org.chamomile.widgets.ContainerSkin;
import org.chamomile.widgets.View;
import org.w3c.dom.html.HTMLElement;

public class BaseContainerSkin<T extends View> extends ContainerSkin<T> {
	protected final HTMLElement element;
	
	public BaseContainerSkin(HTMLElement element) {
		this.element = element;
	}

	@Override
	public HTMLElement getActiveElement() {
		return element;
	}

	@Override
	public HTMLElement getElement() {
		return element;
	}

	@Override
	protected HTMLElement getContainerElement() {
		return element;
	}
}
