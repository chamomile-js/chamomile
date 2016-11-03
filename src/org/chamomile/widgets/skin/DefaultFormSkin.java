package org.chamomile.widgets.skin;

import static j2js.Global.document;

import org.chamomile.widgets.ContainerSkin;
import org.chamomile.widgets.FormGroup;
import org.w3c.dom.html.HTMLDivElement;
import org.w3c.dom.html.HTMLElement;
import org.w3c.dom.html.HTMLFormElement;

public class DefaultFormSkin extends ContainerSkin<FormGroup> implements FormSkin {
	private final HTMLFormElement form;
	private final HTMLDivElement wrapper;

	public DefaultFormSkin() {
		form = (HTMLFormElement) document.createElement("form");
		//form.setClassName("chamomile-view");
		wrapper = (HTMLDivElement) document.createElement("div");
		wrapper.setClassName("chamomile-form chamomile-view-wrapper chamomile-border-box");
		wrapper.appendChild(form);
	}

	@Override
	protected HTMLElement getContainerElement() {
		return form;
	}
	
	@Override
	public HTMLElement getActiveElement() {
		return form;
	}

	@Override
	public HTMLElement getElement() {
		return wrapper;
	}

}
