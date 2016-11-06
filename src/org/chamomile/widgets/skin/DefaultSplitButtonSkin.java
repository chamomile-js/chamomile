package org.chamomile.widgets.skin;

import static j2js.Global.document;

import org.chamomile.widgets.Component;
import org.chamomile.widgets.HasSemanticStyleProperty;
import org.chamomile.widgets.HasSizeStyleProperty;
import org.chamomile.widgets.SemanticStyle;
import org.chamomile.widgets.SizeStyle;
import org.chamomile.widgets.ViewParent;
import org.w3c.dom.html.HTMLAnchorElement;
import org.w3c.dom.html.HTMLElement;

public class DefaultSplitButtonSkin extends DefaultDropdown2Skin implements SplitButtonSkin {
	private final HTMLAnchorElement btn;

	public DefaultSplitButtonSkin() {
		btn = (HTMLAnchorElement) document.createElement("a");
		btn.setClassName("btn");
		anchor.setInnerHTML("<span class=\"sr-only\">Toggle Dropdown</span>");
		anchor.setClassName("btn dropdown-toggle dropdown-toggle-split");
		element.setClassName("chamomile-split-btn btn-group");
		element.insertBefore(btn, anchor);
	}
	
	@Override
	protected void parentChanged(Component splitBtn, ViewParent<?> previousValue) {
		super.parentChanged(splitBtn, previousValue);
		element.setClassName("chamomile-split-btn chamomile-border-box btn-group");
		element.insertBefore(btn, anchor);
	}
	
	@Override
	protected void semanticStyleChanged(HasSemanticStyleProperty component, SemanticStyle previousValue) {
		semanticStyleChanged(component.getSemanticStyle(), previousValue, getClassNamePrefix(),  btn, anchor);
	}
	
	@Override
	protected void sizeStyleChanged(HasSizeStyleProperty component, SizeStyle previousValue) {
		sizeStyleChanged(component.getSizeStyle(), previousValue, getClassNamePrefix(), btn);
	}

	@Override
	public HTMLElement getActiveElement() {
		return btn;
	}
}
