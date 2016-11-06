package org.chamomile.widgets.skin;

import static j2js.Global.document;

import org.w3c.dom.html.HTMLAnchorElement;
import org.w3c.dom.html.HTMLElement;

public class DefaultListGroupAnchorItem extends AbstractListGroupItemSkin {

	public DefaultListGroupAnchorItem() {
		super((HTMLElement) document.createElement("a"));
		((HTMLAnchorElement) listItem).setHref("#");
		listItem.setClassName("list-group-item");
	}
}
