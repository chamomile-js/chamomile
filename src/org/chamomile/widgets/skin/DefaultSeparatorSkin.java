package org.chamomile.widgets.skin;

import static j2js.Global.document;

import org.chamomile.widgets.Component;
import org.chamomile.widgets.ComponentSkin;
import org.chamomile.widgets.Menu;
import org.chamomile.widgets.ViewParent;
import org.w3c.dom.html.HTMLDivElement;
import org.w3c.dom.html.HTMLElement;

public class DefaultSeparatorSkin extends ComponentSkin implements SeparatorSkin {
	private final HTMLDivElement div;

	public DefaultSeparatorSkin() {
		div = (HTMLDivElement) document.createElement("div");
		div.setClassName("chamomile-separator");
	}
	
	@Override
	protected void parentChanged(Component separator, ViewParent<?> previousValue) {
		if(previousValue instanceof Menu) {
			removeClassName(div, "dropdown-divider");
		}
		
		ViewParent<?> newValue = separator.getParent();
		if (newValue instanceof Menu) {
			addClassName(div, "dropdown-divider");
		}
	}

	@Override
	public HTMLElement getActiveElement() {
		return div;
	}

	@Override
	public HTMLElement getElement() {
		return div;
	}
}
