package org.chamomile.widgets.skin;

import static j2js.Global.document;

import org.chamomile.widgets.Component;
import org.chamomile.widgets.ContainerSkin;
import org.w3c.dom.html.HTMLDivElement;
import org.w3c.dom.html.HTMLElement;

public class DefaultGridLayoutRowSkin extends ContainerSkin<Component> implements GridLayoutRowSkin {
	
	private final HTMLDivElement container;

	public DefaultGridLayoutRowSkin() {
		container = (HTMLDivElement) document.createElement("div");
		container.setClassName("row");
	}
	
	@Override
	public void install(Component view) {
		super.install(view);

		//
		// Install property listeners...
		//
		
	}

	@Override
	public HTMLElement getActiveElement() {
		return container;
	}

	@Override
	public HTMLElement getElement() {
		return container;
	}

	@Override
	protected HTMLElement getContainerElement() {
		return container;
	}

}
