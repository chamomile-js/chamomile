package org.chamomile.widgets.skin;

import static j2js.Global.document;

import org.chamomile.widgets.FormControl;
import org.w3c.dom.html.HTMLDivElement;
import org.w3c.dom.html.HTMLElement;
import org.w3c.dom.html.HTMLInputElement;

public class DefaultRadioButtonSkin extends AbstractFormControlSkin implements RadioButtonSkin {
	private final HTMLInputElement input;
	private final HTMLElement span;
	private final HTMLDivElement container;

	public DefaultRadioButtonSkin() {
		input = (HTMLInputElement) document.createElement("input");
		input.setAttribute("type", "radio");
		input.setClassName("form-check-input");
		span = (HTMLInputElement) document.createElement("span");
		container = (HTMLDivElement) document.createElement("div");
		container.setClassName("form-check");
		container.appendChild(label);
		label.getStyle().setDisplay("");
		label.setClassName("form-check-label");
		label.appendChild(input);
		label.appendChild(span);
	}

	@Override
	protected Void labelChanged(FormControl formControl, String previousValue) {
		span.setTextContent(formControl.getLabel());
		return null;
	}

	@Override
	public HTMLElement getActiveElement() {
		return input;
	}

	@Override
	public HTMLElement getElement() {
		return container;
	}
}
