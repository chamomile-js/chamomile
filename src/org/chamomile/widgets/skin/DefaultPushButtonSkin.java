package org.chamomile.widgets.skin;

import static j2js.Global.document;

import org.chamomile.util.Callback;
import org.chamomile.widgets.Component;
import org.chamomile.widgets.ComponentSkin;
import org.chamomile.widgets.PushButton;
import org.w3c.dom.html.HTMLButtonElement;
import org.w3c.dom.html.HTMLDivElement;
import org.w3c.dom.html.HTMLElement;

public class DefaultPushButtonSkin extends ComponentSkin implements PushButtonSkin {
	private final HTMLButtonElement button;
	private final HTMLDivElement wrapper;

	public DefaultPushButtonSkin() {
		button = (HTMLButtonElement) document.createElement("button");
		button.setClassName("btn chamomile-view chamomile-border-box");
		wrapper = (HTMLDivElement) document.createElement("div");
		wrapper.setClassName("chamomile-push-button chamomile-view-wrapper chamomile-border-box");
		wrapper.appendChild(button);
	}

	@Override
	public HTMLElement getActiveElement() {
		return button;
	}

	@Override
	public HTMLElement getElement() {
		return wrapper;
	}

	@Override
	public void install(Component view) {
		super.install(view);

		//
		// Install property listeners...
		//

		propertyChangeHandlers.put(PushButton.TEXT, new Callback<String, Void>() {
			@Override
			public Void call(String previousValue) {
				textChanged((PushButton) getComponent(), previousValue);
				return null;
			}
		});
	}

	protected void textChanged(PushButton view, String previousValue) {
		button.setTextContent(view.getText());
	}
}
