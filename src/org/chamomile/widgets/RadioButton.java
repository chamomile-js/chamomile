package org.chamomile.widgets;

import org.chamomile.widgets.skin.DefaultRadioButtonSkin;
import org.chamomile.widgets.skin.RadioButtonSkin;

public class RadioButton extends FormControl {

	public RadioButton() {
		this(new DefaultRadioButtonSkin());
	}
	
	public RadioButton(RadioButtonSkin skin) {
		setSkin(skin);
	}
}
