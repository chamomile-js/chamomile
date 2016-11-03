package org.chamomile.widgets;

import org.chamomile.widgets.skin.DefaultInputElementSkin;
import org.chamomile.widgets.skin.InputElementSkin;

public class InputElement extends FormControl {
	
	public static enum Type {
		TEXT, PASSWORD, FILE
	}

	public InputElement() {
		this(new DefaultInputElementSkin());
	}
	
	public InputElement(InputElementSkin skin) {
		setSkin(skin);
	}
	
	/**
	 * The component's {@code type} property.
	 */
	public static final String TYPE = "type";
	
	public Type getType() {
		return (Type) get(TYPE, Type.TEXT);
	}
	
	public void setType(Type type) {
		put(TYPE, type);
	}
}
