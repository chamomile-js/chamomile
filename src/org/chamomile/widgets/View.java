package org.chamomile.widgets;

import org.w3c.dom.events.EventTarget;

public interface View extends EventTarget {

	ViewParent<?> getParent();
	
	Component toComponent();
}
