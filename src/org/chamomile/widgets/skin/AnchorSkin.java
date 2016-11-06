package org.chamomile.widgets.skin;

import static j2js.Global.document;

import org.chamomile.widgets.ComponentSkin;
import org.w3c.dom.html.HTMLAnchorElement;
import org.w3c.dom.html.HTMLElement;

public class AnchorSkin extends ComponentSkin {
	protected final HTMLAnchorElement anchor;
	
	public AnchorSkin() {
		anchor = (HTMLAnchorElement) document.createElement("a");
		anchor.setHref("#");
	}

	@Override
	public HTMLElement getActiveElement() {
		return anchor;
	}

	@Override
	public HTMLElement getElement() {
		return anchor;
	}
}
