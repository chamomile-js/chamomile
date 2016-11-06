package org.chamomile.widgets.skin;

import static j2js.Global.document;

import org.chamomile.widgets.ComponentSkin;
import org.w3c.dom.html.HTMLElement;

public abstract class AbstractNavItemSkin extends ComponentSkin {
	protected HTMLElement element;
	
	public AbstractNavItemSkin() {
		element = (HTMLElement) document.createElement("li");
	}

	@Override
	public HTMLElement getElement() {
		return element;
	}
}
