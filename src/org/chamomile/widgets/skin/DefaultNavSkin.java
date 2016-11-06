package org.chamomile.widgets.skin;

import org.chamomile.widgets.Component;
import org.chamomile.widgets.NavItem;
import org.chamomile.widgets.Navbar;
import org.chamomile.widgets.ViewParent;

public class DefaultNavSkin extends HTMLUListSkin<NavItem> implements NavSkin {	

	public DefaultNavSkin() {
		element.setClassName("nav");
	}

	@Override
	protected void parentChanged(Component nav, ViewParent<?> previousValue) {
		if (previousValue instanceof Navbar) {
			removeClassName(element, element.getClassName(), "navbar-nav");
		}
		if (nav.getParent() instanceof Navbar) {
			addClassName(element, element.getClassName(), "navbar-nav");
		}
	}
}
