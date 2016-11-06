package org.chamomile.widgets;

public abstract class AbstractListGroupItem extends Container<Tag> implements ListGroupItem,
		HasSemanticStyleProperty {

	@Override
	public SemanticStyle getSemanticStyle() {
		return (SemanticStyle) get(SEMANTIC_STYLE, SemanticStyle.DEFAULT);
	}

	@Override
	public void setSemanticStyle(SemanticStyle style) {
		put(SEMANTIC_STYLE, style);
	}

}
