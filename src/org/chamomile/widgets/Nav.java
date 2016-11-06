package org.chamomile.widgets;

import org.chamomile.widgets.skin.DefaultNavSkin;
import org.chamomile.widgets.skin.NavSkin;

public class Nav extends Container<NavItem> implements NavbarElement {

	public Nav() {
		this(new DefaultNavSkin());
	}
	
	public Nav(NavSkin skin) {
		setSkin(skin);
	}
}
