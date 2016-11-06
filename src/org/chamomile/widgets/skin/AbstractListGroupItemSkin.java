package org.chamomile.widgets.skin;

import static j2js.Global.document;

import org.chamomile.widgets.Component;
import org.chamomile.widgets.ContainerSkin;
import org.chamomile.widgets.HasTextProperty;
import org.chamomile.widgets.Tag;
import org.w3c.dom.html.HTMLElement;

public abstract class AbstractListGroupItemSkin extends ContainerSkin<Tag> implements ListGroupItemSkin {
	private final HTMLElement content;
	protected final HTMLElement listItem;

	protected AbstractListGroupItemSkin(HTMLElement listItem) {
		content = (HTMLElement) document.createElement("span");
		this.listItem = listItem;
		this.listItem.setClassName("list-group-item");
		this.listItem.appendChild(content);
	}

	@Override
	public void install(Component view) {
		super.install(view);

		//
		// Install property listeners...
		//
	}

	@Override
	protected String getClassNamePrefix() {
		return "list-group-item-";
	}

	@Override
	protected void textChanged(HasTextProperty component, String previousValue) {
		content.setTextContent(component.getText());
	}

	@Override
	public HTMLElement getActiveElement() {
		return listItem;
	}

	@Override
	public HTMLElement getElement() {
		return listItem;
	}

	@Override
	protected HTMLElement getContainerElement() {
		return listItem;
	}
}
