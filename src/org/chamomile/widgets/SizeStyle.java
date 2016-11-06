package org.chamomile.widgets;

public enum SizeStyle {
	LARGER("lg"), SMALLER("sm");
	
	private final String styleName;
	
	private SizeStyle(String styleName) {
		this.styleName = styleName;
	}

	public String getStyleName() {
		return styleName;
	}
}
