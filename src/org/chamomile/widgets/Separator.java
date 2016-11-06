package org.chamomile.widgets;

import org.chamomile.widgets.skin.DefaultSeparatorSkin;
import org.chamomile.widgets.skin.SeparatorSkin;

public class Separator extends Component implements MenuItem {

	public Separator() {
		this(new DefaultSeparatorSkin());
	}
	
	public Separator(SeparatorSkin skin) {
		setSkin(skin);
	}
}
