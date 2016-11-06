package org.chamomile.widgets.skin;

import static j2js.Global.document;

import org.chamomile.widgets.View;
import org.w3c.dom.html.HTMLElement;

public class HTMLUListSkin<T extends View> extends BaseContainerSkin<T> {
	
	public HTMLUListSkin() {
		super((HTMLElement) document.createElement("ul"));
	}

}
