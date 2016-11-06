package org.chamomile.widgets.skin;

import static j2js.Global.document;

import org.chamomile.util.Callback;
import org.chamomile.widgets.Component;
import org.chamomile.widgets.ComponentSkin;
import org.chamomile.widgets.NavbarBrand;
import org.w3c.dom.html.HTMLAnchorElement;
import org.w3c.dom.html.HTMLElement;

public class DefaultNavbarBrandSking extends ComponentSkin implements NavbarItemSking {
	private final HTMLAnchorElement anchor;
	
	public DefaultNavbarBrandSking() {
		anchor = (HTMLAnchorElement) document.createElement("a");
		anchor.setClassName("navbar-brand");
		anchor.setHref("#");
	}

	@Override
	public void install(Component view) {
		super.install(view);

		//
		// Install property listeners...
		//

		propertyChangeHandlers.put(NavbarBrand.HTML, new Callback<String, Void>() {
			@Override
			public Void call(String previousValue) {
				return htmlChanged((NavbarBrand) getComponent(), previousValue);
			}
		});
	}

	protected Void htmlChanged(NavbarBrand navbarBrand, String previousValue) {
		anchor.setInnerHTML(navbarBrand.getHTML());
		return null;
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
