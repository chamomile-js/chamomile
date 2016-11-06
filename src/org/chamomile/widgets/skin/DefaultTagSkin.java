package org.chamomile.widgets.skin;

import static j2js.Global.document;

import org.chamomile.util.Callback;
import org.chamomile.widgets.Component;
import org.chamomile.widgets.ComponentSkin;
import org.chamomile.widgets.ListGroupItem;
import org.chamomile.widgets.Tag;
import org.chamomile.widgets.ViewParent;
import org.w3c.dom.html.HTMLElement;

public class DefaultTagSkin extends ComponentSkin implements TagSkin {
	private final HTMLElement span;

	public DefaultTagSkin() {
		span = (HTMLElement) document.createElement("span");
		span.setClassName("tag tag-default");
	}	
	
	@Override
	public void install(Component view) {
		super.install(view);

		//
		// Install property listeners...
		//

		propertyChangeHandlers.put(Tag.PILL, new Callback<Boolean, Void>() {
			@Override
			public Void call(Boolean previousValue) {
				pillChanged((Tag) getComponent(), previousValue);
				return null;
			}
		});
	}

	protected void pillChanged(Tag tag, Boolean previousValue) {
		if (previousValue != null && previousValue) {
			removeClassName(span, getClassNamePrefix() + "pill");
		}
		if (tag.isPill()) {
			addClassName(span, getClassNamePrefix() + "pill");
		}
	}

	@Override
	protected void parentChanged(Component tag, ViewParent<?> previousValue) {
		if (previousValue instanceof ListGroupItem) {
			removeClassName(span, "float-xs-right");
		}

		ViewParent<?> newValue = tag.getParent();
		if (newValue instanceof ListGroupItem) {
			addClassName(span, "float-xs-right");
		}
	}

	@Override
	protected String getClassNamePrefix() {
		return "tag-";
	}

	@Override
	public HTMLElement getActiveElement() {
		return span;
	}

	@Override
	public HTMLElement getElement() {
		return span;
	}
}
