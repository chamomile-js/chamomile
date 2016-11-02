package org.chamomile.widgets.skin;

import static j2js.Global.document;

import org.chamomile.util.Callback;
import org.chamomile.widgets.Component;
import org.chamomile.widgets.ContainerSkin;
import org.chamomile.widgets.GridLayout;
import org.chamomile.widgets.GridLayoutRow;

import j2js.w3c.dom.html.HTMLDivElement;
import j2js.w3c.dom.html.HTMLElement;

public class DefaultGridLayoutSkin extends ContainerSkin<GridLayoutRow> implements GridLayoutSkin {
	private final HTMLDivElement container;
	private final HTMLDivElement wrapper;

	public DefaultGridLayoutSkin() {
		container = (HTMLDivElement) document.createElement("div");
		//container.setClassName("chamomile-view");
		wrapper = (HTMLDivElement) document.createElement("div");
		wrapper.setClassName("chamomile-grid-layout chamomile-view-wrapper chamomile-border-box");
		wrapper.appendChild(container);
	}

	@Override
	public void install(Component view) {
		super.install(view);

		//
		// Install property listeners...
		//

		propertyChangeHandlers.put(GridLayout.FLUID, new Callback<Boolean, Void>() {
			@Override
			public Void call(Boolean previousValue) {
				return fluidChanged((GridLayout) getComponent(), previousValue);
			}
		});
	}

	protected Void fluidChanged(GridLayout gridLayout, Boolean previousValue) {
		HTMLElement elem = getActiveElement();
		if (previousValue != null) {
			removeClassName(elem, elem.getClassName(), previousValue ? "container-fluid" : "container");
		}
		addClassName(elem, elem.getClassName(), gridLayout.isFluid() ? "container-fluid" : "container");
		return null;
	}

	@Override
	public HTMLElement getElement() {
		return wrapper;
	}

	@Override
	public HTMLElement getActiveElement() {
		return container;
	}

	@Override
	protected HTMLElement getContainerElement() {
		return container;
	}

}
