package org.chamomile.widgets.skin;

import static j2js.Global.document;

import org.chamomile.widgets.ContainerSkin;
import org.chamomile.widgets.MenuItem;
import org.w3c.dom.html.HTMLDivElement;
import org.w3c.dom.html.HTMLElement;

public class DefaultMenuSkin extends ContainerSkin<MenuItem> implements MenuSkin {
	private final HTMLDivElement div;

	public DefaultMenuSkin() {
		div = (HTMLDivElement) document.createElement("div");
		div.setClassName("chamomile-menu dropdown-menu");
	}

	@Override
	public HTMLElement getActiveElement() {
		return div;
	}

	@Override
	public HTMLElement getElement() {
		return div;
	}

	@Override
	protected HTMLElement getContainerElement() {
		return div;
	}

}
