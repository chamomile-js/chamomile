package org.chamomile.widgets.skin;

import static j2js.Global.document;

import org.chamomile.widgets.Component;
import org.chamomile.widgets.ContainerSkin;
import org.chamomile.widgets.ListGroupItem;
import org.w3c.dom.html.HTMLDivElement;
import org.w3c.dom.html.HTMLElement;
import org.w3c.dom.html.HTMLUListElement;

public class DefaultListGroupSkin extends ContainerSkin<ListGroupItem> implements ListGroupSkin {
	private final HTMLUListElement container;
	private final HTMLDivElement wrapper;
	
	public DefaultListGroupSkin() {
		container = (HTMLUListElement) document.createElement("ul");
		container.setClassName("list-group");
		wrapper = (HTMLDivElement) document.createElement("div");
		wrapper.setClassName("chamomile-list-group chamomile-view-wrapper chamomile-border-box");
		wrapper.appendChild(container);
	}
	
	@Override
	public void install(Component view) {
		super.install(view);

		//
		// Install property listeners...
		//
		
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
