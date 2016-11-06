package org.chamomile.widgets.skin;

import static j2js.Global.document;

import org.chamomile.util.Callback;
import org.chamomile.widgets.Component;
import org.chamomile.widgets.Dropdown2;
import org.chamomile.widgets.HashMenuProperty;
import org.chamomile.widgets.Menu;
import org.chamomile.widgets.Nav;
import org.chamomile.widgets.ViewParent;
import org.w3c.dom.Node;
import org.w3c.dom.html.HTMLElement;

public class DefaultDropdown2Skin extends DefaultNavItemAnchorSkin implements NavItemSkin {

	public DefaultDropdown2Skin() {
		anchor.setClassName("dropdown-toggle");
		anchor.setAttribute("data-toggle", "dropdown");
		anchor.setAttribute("aria-haspopup", "true");
		anchor.setAttribute("aria-expanded", "true");
		anchor.setId("dropdown" + hashCode());// anchor id
		element.setClassName("chamomile-dropdown dropdown");
		element.appendChild(anchor);
	}

	@Override
	public void install(Component view) {
		super.install(view);

		//
		// Install property listeners...
		//

		propertyChangeHandlers.put(HashMenuProperty.MENU, new Callback<Menu, Void>() {
			@Override
			public Void call(Menu previousValue) {
				return menuChanged((Dropdown2) getComponent(), previousValue);
			}
		});
	}

	@Override
	protected String getClassNamePrefix() {
		return "btn-";
	}

	protected Void menuChanged(Dropdown2 dropdown, Menu previousValue) {
		if (previousValue != null) {
			HTMLElement menuElem = getSkin(previousValue).getElement();
			element.removeChild(menuElem);
		}

		Menu newMenu = dropdown.getMenu();
		if (newMenu != null) {
			HTMLElement menuElem = getSkin(newMenu).getElement();
			menuElem.setAttribute("aria-labelledby", anchor.getId());
			element.appendChild(getSkin(newMenu).getElement());
		}
		return null;
	}

	@Override
	protected void parentChanged(Component dropdown, ViewParent<?> previousValue) {
		if (previousValue instanceof Nav) {
			removeClassName(getActiveElement(), getActiveElement().getClassName(), "nav-link");
			removeClassName(getElement(), getElement().getClassName(), "nav-item");
		} else if (previousValue != null) {
			removeClassName(getActiveElement(), getActiveElement().getClassName(), "btn btn-secondary");
		}

		if (dropdown.getParent() instanceof Nav) {

			if (!("LI".equalsIgnoreCase(element.getTagName()))) {
				HTMLElement oldElement = element;
				element = (HTMLElement) document.createElement("li");
				element.setClassName("nav-item dropdown");
				element.setAttribute("data-toggle", "dropdown");
				element.appendChild(anchor);

				Menu newMenu = ((Dropdown2) dropdown).getMenu();
				if (newMenu != null) {
					Node menuNode = getSkin(newMenu).getElement();
					// oldElement.removeChild(menuNode);
					element.appendChild(menuNode);
				}

				Node parentNode = oldElement.getParentNode();
				if (parentNode != null)
					parentNode.replaceChild(element, oldElement);
			}

			addClassName(getActiveElement(), getActiveElement().getClassName(), "nav-link");
			addClassName(getElement(), getElement().getClassName(), "nav-item");

		} else {

			if ("LI".equalsIgnoreCase(element.getTagName())) {
				HTMLElement oldElement = element;
				element = (HTMLElement) document.createElement("div");
				element.setClassName("chamomile-dropdown chamomile-border-box dropdown");
				element.setAttribute("data-toggle", "dropdown");
				element.appendChild(anchor);

				Menu newMenu = ((Dropdown2) dropdown).getMenu();
				if (newMenu != null) {
					Node menuNode = getSkin(newMenu).getElement();
					// oldElement.removeChild(menuNode);
					element.appendChild(menuNode);
				}

				Node parentNode = oldElement.getParentNode();
				if (parentNode != null)
					parentNode.replaceChild(element, oldElement);
			}

			addClassName(getActiveElement(), getActiveElement().getClassName(), "btn");
		}
	}
}
