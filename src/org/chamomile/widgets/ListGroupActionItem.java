package org.chamomile.widgets;

import org.chamomile.widgets.skin.DefaultListGroupActionItem;
import org.chamomile.widgets.skin.ListGroupItemSkin;

public class ListGroupActionItem extends ListGroupAnchorItem {

	public ListGroupActionItem() {
		super(new DefaultListGroupActionItem());
	}

	public ListGroupActionItem(ListGroupItemSkin skin) {
		super(skin);
	}
}
