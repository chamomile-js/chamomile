package org.chamomile.widgets;

import org.chamomile.widgets.skin.DefaultNavbarSkin;
import org.chamomile.widgets.skin.NavbarSkin;

public class Navbar extends Container<NavbarElement> {

	public Navbar() {
		this(new DefaultNavbarSkin());
	}
	
	public Navbar(NavbarSkin skin) {
		setSkin(skin);
	}
}
