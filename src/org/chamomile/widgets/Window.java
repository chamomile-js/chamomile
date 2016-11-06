package org.chamomile.widgets;

import static j2js.Global.document;

public class Window extends GridLayout {

	public Window() {
		document.getBody().appendChild(getSkin().getElement());
	}
}
