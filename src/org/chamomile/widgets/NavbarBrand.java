package org.chamomile.widgets;

import org.chamomile.widgets.skin.DefaultNavbarBrandSking;
import org.chamomile.widgets.skin.NavbarItemSking;

public class NavbarBrand extends Component implements NavbarElement {

	public NavbarBrand() {
		this(new DefaultNavbarBrandSking());
	}
	
	public NavbarBrand(NavbarItemSking skin) {
		setSkin(skin);
	}
	
	/**
	 * The {@code NavbarBrand}'s HTML property.
	 */
	public static final String HTML = "html";
	
	public String getHTML() {
		return (String) get(HTML, "");
	}

	public void setHTML(String html) {
		put(HTML, html);
	}
}
