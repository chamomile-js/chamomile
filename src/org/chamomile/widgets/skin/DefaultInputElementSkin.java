package org.chamomile.widgets.skin;

import static j2js.Global.document;

import org.chamomile.util.Callback;
import org.chamomile.widgets.Component;
import org.chamomile.widgets.InputElement;
import org.chamomile.widgets.InputElement.Type;
import org.w3c.dom.html.HTMLDivElement;
import org.w3c.dom.html.HTMLElement;
import org.w3c.dom.html.HTMLInputElement;

public class DefaultInputElementSkin extends AbstractFormControlSkin implements InputElementSkin {
	private final HTMLInputElement input;
	private final HTMLDivElement container;

	public DefaultInputElementSkin() {
		input = (HTMLInputElement) document.createElement("input");
		input.setClassName("form-control");
		container = (HTMLDivElement) document.createElement("div");
		container.setClassName("form-group");
		container.appendChild(label);
		container.appendChild(input);
	}

	@Override
	public void install(Component view) {
		super.install(view);

		//
		// Install property listeners...
		//

		propertyChangeHandlers.put(InputElement.TYPE, new Callback<InputElement.Type, Void>() {
			@Override
			public Void call(InputElement.Type previousValue) {
				return typeChanged((InputElement) getComponent(), previousValue);
			}
		});

	}

	protected Void typeChanged(InputElement inputGroup, Type previousValue) {
		InputElement.Type type = inputGroup.getType();
		input.setAttribute("type", type.toString().toLowerCase());

		if (type == Type.FILE) {
			removeClassName(input, input.getClassName(), "form-control");
			addClassName(input, input.getClassName(), "form-control-file");
		} else if (previousValue == Type.FILE) {
			removeClassName(input, input.getClassName(), "form-control-file");
			addClassName(input, input.getClassName(), "form-control");
		}

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
