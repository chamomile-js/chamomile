package org.chamomile.widgets.skin;

import static j2js.Global.document;

import org.chamomile.collections.Sequence;
import org.chamomile.util.Callback;
import org.chamomile.widgets.Component;
import org.chamomile.widgets.ComponentSkin;
import org.chamomile.widgets.FieldSet;
import org.chamomile.widgets.FormGroup;
import org.chamomile.widgets.ViewParent;
import org.chamomile.widgets.ViewParentListener;
import org.w3c.dom.NodeList;
import org.w3c.dom.html.HTMLElement;
import org.w3c.dom.html.HTMLFieldSetElement;
import org.w3c.dom.html.HTMLLegendElement;

public class DefaultFieldSetSkin extends ComponentSkin implements FieldSetSkin, ViewParentListener<FormGroup> {
	private final HTMLLegendElement legend;
	private final HTMLFieldSetElement container;

	public DefaultFieldSetSkin() {
		legend = (HTMLLegendElement) document.createElement("legend");
		legend.getStyle().setDisplay("none");
		container = (HTMLFieldSetElement) document.createElement("fieldset");
		container.setClassName("form-group");
		container.appendChild(legend);
	}

	@Override
	public void install(Component component) {
		super.install(component);

		// Add this as a field set listener
		FieldSet fieldSet = (FieldSet) component;
		fieldSet.getFieldSetListeners().add(this);

		//
		// Install property listeners...
		//

		propertyChangeHandlers.put(FieldSet.LEGEND, new Callback<String, Void>() {
			@Override
			public Void call(String previousValue) {
				return legendChanged((FieldSet) getComponent(), previousValue);
			}
		});
	}

	protected Void legendChanged(FieldSet fieldSet, String previousValue) {
		String text = fieldSet.getLegend();
		legend.setTextContent(text);
		if (text != null && !text.trim().equals("")) {
			legend.getStyle().setDisplay("");
		} else {
			legend.getStyle().setDisplay("none");
		}
		return null;
	}
	
	// ---
	
	@Override
	public void viewInserted(ViewParent<FormGroup> container, int index) {
		HTMLElement parentElem = getContainerElement();
		Component component = container.getChildren().get(index);
		if (component != null) {
			HTMLElement newElem = getSkin(component).getElement();
			if (index >= parentElem.getChildElementCount() + 1) {
				parentElem.appendChild(newElem);
			} else {
				NodeList childNodes = parentElem.getChildNodes();
				parentElem.insertBefore(newElem, childNodes.item(index + 1));
			}
		}
	}

	@Override
	public void viewsRemoved(ViewParent<FormGroup> container, int index, Sequence<FormGroup> removed) {
		HTMLElement parentElem = getContainerElement();
		for (int i = 0, n = removed.getLength(); i < n; i++) {
			Component component = removed.get(i);
			if (component != null) {
				HTMLElement elem = getSkin(component).getElement();
				parentElem.removeChild(elem);
			}
		}
	}

	@Override
	public void viewMoved(ViewParent<FormGroup> container, int from, int to) {
		throw new UnsupportedOperationException("Not implemented yet!!!");
	}

	protected HTMLElement getContainerElement() {
		return container;
	}

	@Override
	public HTMLElement getActiveElement() {
		return container;
	}

	@Override
	public HTMLElement getElement() {
		return container;
	}
}
