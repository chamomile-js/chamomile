package org.chamomile.widgets;

public abstract class FormControl extends FormGroup {

	/**
	 * The form group's label property.
	 */
	public static final String LABEL = "label";

	public String getLabel() {
		return (String) get(LABEL, "");
	}

	public void setLabel(String label) {
		put(LABEL, label);
	}

	/**
	 * The form group's name property.
	 */
	public static final String NAME = "name";

	public String getName() {
		return (String) get(NAME, "");
	}

	public void setName(String name) {
		put(NAME, name);
	}

}
