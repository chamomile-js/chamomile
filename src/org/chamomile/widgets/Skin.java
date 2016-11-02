package org.chamomile.widgets;

import j2js.w3c.dom.html.HTMLElement;

public interface Skin {

	void install(Component component);

	Component getComponent();

	int getOffsetTop();

	int getOffsetLeft();

	int getOffsetWidth();

	int getOffsetHeight();

	HTMLElement getActiveElement();
	
	HTMLElement getElement();
}
