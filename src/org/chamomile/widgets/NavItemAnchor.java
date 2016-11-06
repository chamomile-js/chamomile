package org.chamomile.widgets;

import org.chamomile.widgets.skin.DefaultNavItemAnchorSkin;
import org.chamomile.widgets.skin.NavItemSkin;

public class NavItemAnchor extends Component implements NavItem, HasTextProperty {

	public NavItemAnchor() {
		this(new DefaultNavItemAnchorSkin());
	}

	public NavItemAnchor(NavItemSkin skin) {
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
