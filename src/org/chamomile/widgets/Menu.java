package org.chamomile.widgets;

import org.chamomile.widgets.skin.DefaultMenuSkin;
import org.chamomile.widgets.skin.MenuSkin;

public class Menu extends Container<MenuItem> {
	
	public Menu() {
		this(new DefaultMenuSkin());
	}
	
	public Menu(MenuSkin skin) {
		setSkin(skin);
	}

}
