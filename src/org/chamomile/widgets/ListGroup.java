package org.chamomile.widgets;

import org.chamomile.widgets.skin.DefaultListGroupSkin;
import org.chamomile.widgets.skin.ListGroupSkin;

public class ListGroup extends Container<ListGroupItem> {
	
	public ListGroup() {
		this(new DefaultListGroupSkin());
	}

	public ListGroup(ListGroupSkin skin) {
		setSkin(skin);
	}
}
