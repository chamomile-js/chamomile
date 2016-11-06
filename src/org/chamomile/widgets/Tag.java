package org.chamomile.widgets;

import org.chamomile.widgets.skin.DefaultTagSkin;
import org.chamomile.widgets.skin.TagSkin;

public class Tag extends Component implements HasTextProperty, HasSemanticStyleProperty {
	
	public Tag(String text) {
		this(new DefaultTagSkin());
		setText(text);
	}
	
	public Tag(String text, SemanticStyle style) {
		this(new DefaultTagSkin());
		setText(text);
		setSemanticStyle(style);
	}
	
	public Tag(String text, SemanticStyle style, boolean pill) {
		this(new DefaultTagSkin());
		setText(text);
		setSemanticStyle(style);
		setPill(pill);
	}
	
	public Tag(TagSkin skin) {
		setSkin(skin);
	}

	@Override
	public SemanticStyle getSemanticStyle() {
		return (SemanticStyle) get(SEMANTIC_STYLE, SemanticStyle.DEFAULT);
	}

	@Override
	public void setSemanticStyle(SemanticStyle style) {
		put(SEMANTIC_STYLE, style);
	}

	@Override
	public String getText() {
		return (String) get(TEXT, "");
	}

	@Override
	public void setText(String text) {
		put(TEXT, text);
	}
	
	public static final String PILL = "pill";
	
	public boolean isPill() {
		return (boolean) get(PILL, Boolean.FALSE);
	}

	public void setPill(boolean pill) {
		put(PILL, pill);
	}
}
