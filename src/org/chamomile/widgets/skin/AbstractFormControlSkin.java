package org.chamomile.widgets.skin;

import static j2js.Global.document;

import org.chamomile.util.Callback;
import org.chamomile.widgets.Component;
import org.chamomile.widgets.ComponentSkin;
import org.chamomile.widgets.FormControl;
import org.w3c.dom.html.HTMLLabelElement;

public abstract class AbstractFormControlSkin extends ComponentSkin {
	protected final HTMLLabelElement label;
	
	public AbstractFormControlSkin() {
		label = (HTMLLabelElement) document.createElement("label");
		label.getStyle().setDisplay("none");
	}
	
	@Override
	public void install(Component view) {
		super.install(view);

		//
		// Install property listeners...
		//

		propertyChangeHandlers.put(FormControl.LABEL, new Callback<String, Void>() {
			@Override
			public Void call(String previousValue) {
				return labelChanged((FormControl) getComponent(), previousValue);
			}
		});

		propertyChangeHandlers.put(FormControl.NAME, new Callback<String, Void>() {
			@Override
			public Void call(String previousValue) {
				return nameChanged((FormControl) getComponent(), previousValue);
			}
		});
		
	}

	@Override
	protected void idChanged(Component component, String previousValue) {
		super.idChanged(component, previousValue);

		if (label != null) {
			label.setHtmlFor(component.getId());
		}
	}

	protected Void labelChanged(FormControl formControl, String previousValue) {
		String text = formControl.getLabel();
		label.setTextContent(text);
		if (text != null && !text.trim().equals("")) {
			label.getStyle().setDisplay("");
		} else {
			label.getStyle().setDisplay("none");
		}
		return null;
	}

	protected Void nameChanged(FormControl formControl, String previousValue) {
		getActiveElement().setAttribute("name", formControl.getName());
		return null;
	}

}
