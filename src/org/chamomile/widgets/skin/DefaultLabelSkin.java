package org.chamomile.widgets.skin;

import static j2js.Global.document;

import org.chamomile.util.Callback;
import org.chamomile.widgets.Component;
import org.chamomile.widgets.ComponentSkin;
import org.chamomile.widgets.Label;
import org.w3c.dom.html.HTMLDivElement;
import org.w3c.dom.html.HTMLElement;
import org.w3c.dom.html.HTMLLabelElement;

public class DefaultLabelSkin extends ComponentSkin implements LabelSkin {
	private final HTMLLabelElement label;
	private final HTMLDivElement wrapper;

	public DefaultLabelSkin() {
		label = (HTMLLabelElement) document.createElement("label");
		label.setClassName("chamomile-view chamomile-border-box");
		label.getStyle().setWhiteSpace("nowrap");
		wrapper = (HTMLDivElement) document.createElement("div");
		wrapper.setClassName("chamomile-label chamomile-view-wrapper chamomile-border-box");
		wrapper.appendChild(label);
	}

	@Override
	public void install(Component view) {
		super.install(view);

		//
		// Install property listeners...
		//

		propertyChangeHandlers.put(Label.TEXT, new Callback<String, Void>() {
			@Override
			public Void call(String previousValue) {
				return textChanged((Label) getComponent(), previousValue);
			}
		});

		propertyChangeHandlers.put(Label.LABELED_CONTROL_ID, new Callback<String, Void>() {
			@Override
			public Void call(String previousValue) {
				return labeledControlIdChanged((Label) getComponent(), previousValue);
			}
		});

		propertyChangeHandlers.put(Label.WORD_WRAP, new Callback<Boolean, Void>() {
			@Override
			public Void call(Boolean previousValue) {
				return wordWrapChanged((Label) getComponent(), previousValue);
			}
		});
	}

	protected Void textChanged(Label view, String previousValue) {
		label.setTextContent(view.getText());
		return null;
	}

	protected Void labeledControlIdChanged(Label view, String previousValue) {
		label.setHtmlFor(view.getLabeledControlId());
		return null;
	}

	protected Void wordWrapChanged(Label view, Boolean previousValue) {
		label.getStyle().setWhiteSpace(view.isWordWrap() ? "normal" : "nowrap");
		return null;
	}

	@Override
	public HTMLElement getElement() {
		return wrapper;
	}

	@Override
	public HTMLElement getActiveElement() {
		return label;
	}

}
