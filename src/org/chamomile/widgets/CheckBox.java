package org.chamomile.widgets;

import org.chamomile.widgets.skin.CheckBoxSkin;
import org.chamomile.widgets.skin.DefaultCheckBoxSkin;

public class CheckBox extends FormControl {

	public CheckBox() {
		this(new DefaultCheckBoxSkin());
	}

	public CheckBox(CheckBoxSkin skin) {
		setSkin(skin);
	}
}
