package org.chamomile.widgets;

import org.chamomile.widgets.skin.DefaultTextAreaSkin;
import org.chamomile.widgets.skin.TextAreaSkin;

public class TextArea extends FormControl {

	public TextArea() {
		this(new DefaultTextAreaSkin());
	}
	
	public TextArea(TextAreaSkin skin) {
		setSkin(skin);
	}
}
