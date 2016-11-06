package org.chamomile.widgets;

import org.chamomile.widgets.skin.DefaultSplitButtonSkin;
import org.chamomile.widgets.skin.NavItemSkin;

public class SplitButton extends Dropdown2 {

	public SplitButton() {
		this(new DefaultSplitButtonSkin());
	}
	
	public SplitButton(NavItemSkin skin) {
		super(skin);
	}
}
