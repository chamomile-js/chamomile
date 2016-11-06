package org.chamomile.widgets;

public interface HasSemanticStyleProperty {
	
	static final String SEMANTIC_STYLE = "semanticStyle";

	SemanticStyle getSemanticStyle();
	
	void setSemanticStyle(SemanticStyle style);
}
