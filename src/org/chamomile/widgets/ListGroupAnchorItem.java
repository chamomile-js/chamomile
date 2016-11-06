package org.chamomile.widgets;

import org.chamomile.widgets.skin.DefaultListGroupAnchorItem;
import org.chamomile.widgets.skin.ListGroupItemSkin;

public class ListGroupAnchorItem extends AbstractListGroupItem implements HasTextProperty {

	public ListGroupAnchorItem() {
		this(new DefaultListGroupAnchorItem());
	}

	public ListGroupAnchorItem(ListGroupItemSkin skin) {
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
