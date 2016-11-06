package org.chamomile.widgets.skin;

import static j2js.Global.document;

import org.chamomile.widgets.Component;
import org.w3c.dom.html.HTMLAnchorElement;
import org.w3c.dom.html.HTMLElement;

public class DefaultNavItemAnchorSkin extends AbstractNavItemSkin implements NavItemSkin {
	protected final HTMLAnchorElement anchor;
	
	public DefaultNavItemAnchorSkin() {
		anchor = (HTMLAnchorElement) document.createElement("a");
		anchor.setClassName("nav-link");
		anchor.setHref("#");
		element.setClassName("nav-item");
		element.appendChild(anchor);
	}
	
	@Override
	public void install(Component view) {
		super.install(view);

		//
		// Install property listeners...
		//

	}

	@Override
	public HTMLElement getActiveElement() {
		return anchor;
	}
}
