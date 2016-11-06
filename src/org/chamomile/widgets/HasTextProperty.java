package org.chamomile.widgets;

public interface HasTextProperty {

	/** The implementor's text property. */
	static final String TEXT = "text";

	String getText();
	
	void setText(String text);
}
