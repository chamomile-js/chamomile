package org.chamomile.widgets;

import org.chamomile.widgets.skin.DefaultMenuItemAnchorSkin;
import org.chamomile.widgets.skin.MenuItemSkin;

public class MenuItemAnchor extends Component implements MenuItem, HasTextProperty {
	
	public MenuItemAnchor() {
		this(new DefaultMenuItemAnchorSkin());
	}
	
	public MenuItemAnchor(MenuItemSkin skin) {
		setSkin(skin);
	}

	@Override
	public String getText() {
		return (String) get(TEXT, "");
	}

	@Override
	public void setText(String text) {
		put(TEXT, text);
	}

}
