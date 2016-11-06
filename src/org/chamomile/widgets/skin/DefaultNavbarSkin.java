package org.chamomile.widgets.skin;

import static j2js.Global.document;

import org.chamomile.widgets.NavbarElement;
import org.w3c.dom.html.HTMLElement;

public class DefaultNavbarSkin extends HTMLDivSkin<NavbarElement> implements NavbarSkin {
	private final HTMLElement nav;
	
	public DefaultNavbarSkin() {
		nav = (HTMLElement) document.createElement("nav");
		nav.setClassName("chamomile-view navbar navbar-full navbar-light bg-faded");
		element.setClassName("chamomile-navbar chamomile-view-wrapper chamomile-border-box");
		element.appendChild(nav);
	}
	
	@Override
	public HTMLElement getActiveElement() {
		return nav;
	}

	@Override
	protected HTMLElement getContainerElement() {
		return nav;
	}

}
