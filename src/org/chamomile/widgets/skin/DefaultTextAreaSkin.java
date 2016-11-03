package org.chamomile.widgets.skin;

import static j2js.Global.document;

import org.w3c.dom.html.HTMLDivElement;
import org.w3c.dom.html.HTMLElement;
import org.w3c.dom.html.HTMLTextAreaElement;

public class DefaultTextAreaSkin extends AbstractFormControlSkin implements TextAreaSkin {
	private final HTMLTextAreaElement textArea;
	private final HTMLDivElement container;

	public DefaultTextAreaSkin() {
		textArea = (HTMLTextAreaElement) document.createElement("textarea");
		textArea.setClassName("form-control");
		container = (HTMLDivElement) document.createElement("div");
		container.setClassName("form-group");
		container.appendChild(label);
		container.appendChild(textArea);
	}

	@Override
	public HTMLElement getActiveElement() {
		return textArea;
	}

	@Override
	public HTMLElement getElement() {
		return container;
	}

}
