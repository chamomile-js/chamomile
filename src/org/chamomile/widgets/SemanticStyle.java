package org.chamomile.widgets;

public enum SemanticStyle {
	DEFAULT("default"),
	
	PRIMARY("primary"), 
	SECONDARY("secondary"), 
	SUCCESS("success"), 
	INFO("info"), 
	WARNING("warning"), 
	DANGER("danger"), 
	
	OUTLINE_PRIMARY("outline-primary"), 
	OUTLINE_SECONDARY("outline-secondary"), 
	OUTLINE_SUCCESS("outline-success"), 
	OUTLINE_INFO("outline-info"), 
	OUTLINE_WARNING("outline-warning"), 
	OUTLINE_DANGER("outline-danger"), 
	
	LINK("link");
	
	private String styleName;

	private SemanticStyle(String styleNname) {
		this.styleName = styleNname;
	}
	
	public String getStyleName() {
		return styleName;
	}
}
