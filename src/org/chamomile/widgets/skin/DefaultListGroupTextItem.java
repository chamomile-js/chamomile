package org.chamomile.widgets.skin;

import static j2js.Global.document;

import org.w3c.dom.html.HTMLElement;

public class DefaultListGroupTextItem extends AbstractListGroupItemSkin implements ListGroupItemSkin {

	public DefaultListGroupTextItem() {
		super((HTMLElement)document.createElement("li"));
	}
}
