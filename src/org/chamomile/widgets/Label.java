package org.chamomile.widgets;

import org.chamomile.widgets.skin.DefaultLabelSkin;
import org.chamomile.widgets.skin.LabelSkin;

public class Label extends Component {

	public Label() {
		this(new DefaultLabelSkin());
	}

	public Label(LabelSkin skin) {
		setSkin(skin);
	}

	/**
	 * The label's text property.
	 */
	public static final String TEXT = "text";

	public String getText() {
		return (String) get(TEXT, "");
	}

	public void setText(String text) {
		put(TEXT, text);
	}

	/**
	 * The labeled control id property;
	 */
	public static final String LABELED_CONTROL_ID = "labeledControlId";

	public String getLabeledControlId() {
		return (String) get(LABELED_CONTROL_ID);
	}

	public void setLabeledControlId(String text) {
		put(LABELED_CONTROL_ID, text);
	}

	/**
	 * The word wrap property.
	 */
	public static final String WORD_WRAP = "wordWrap";

	public boolean isWordWrap() {
		return (Boolean) get(WORD_WRAP, Boolean.FALSE);
	}

	public void setWordWrap(boolean wordWrap) {
		put(WORD_WRAP, Boolean.valueOf(wordWrap));
	}
}
