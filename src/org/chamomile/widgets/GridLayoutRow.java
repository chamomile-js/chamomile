package org.chamomile.widgets;

import org.chamomile.widgets.skin.DefaultGridLayoutRowSkin;

public class GridLayoutRow extends Container<Component> {

	public GridLayoutRow() {
		setSkin(new DefaultGridLayoutRowSkin());
	}
}
