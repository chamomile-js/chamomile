package org.chamomile.widgets;

import j2js.Global;

public class Activity {

	private final GridLayout container;

	public Activity() {
		container = new GridLayout();

		Global.document.getBody().appendChild(container.getSkin().getElement());
	}

	public GridLayout getContainer() {
		return container;
	}
}
