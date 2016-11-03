package org.chamomile.widgets;

import org.chamomile.widgets.skin.DefaultFormSkin;
import org.chamomile.widgets.skin.FormSkin;

public class Form extends Container<FormGroup> {

	public Form() {
		this(new DefaultFormSkin());
	}
	
	public Form(FormSkin skin) {
		setSkin(skin);
	}

}
