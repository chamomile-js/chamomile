package org.chamomile.widgets;

import org.chamomile.widgets.skin.DefaultListGroupTextItem;
import org.chamomile.widgets.skin.ListGroupItemSkin;

public class ListGroupTextItem extends AbstractListGroupItem implements HasTextProperty {

	public ListGroupTextItem() {
		this(new DefaultListGroupTextItem());
	}

	public ListGroupTextItem(ListGroupItemSkin skin) {
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
