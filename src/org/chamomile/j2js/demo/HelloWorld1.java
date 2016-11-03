package org.chamomile.j2js.demo;

import org.chamomile.widgets.Activity;
import org.chamomile.widgets.CheckBox;
import org.chamomile.widgets.FieldSet;
import org.chamomile.widgets.Form;
import org.chamomile.widgets.GridLayout;
import org.chamomile.widgets.GridLayoutRow;
import org.chamomile.widgets.InputElement;
import org.chamomile.widgets.InputElement.Type;
import org.chamomile.widgets.Label;
import org.chamomile.widgets.PushButton;
import org.chamomile.widgets.RadioButton;
import org.chamomile.widgets.TextArea;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;

import j2js.Global;

public class HelloWorld1 {

	public static void main(String[] args) throws Exception {
		Activity activity = new Activity();
		GridLayout layout = activity.getContainer();
		activity.getContainer().setFluid(true);

		GridLayoutRow row = new GridLayoutRow();
		row.getClassNames().add("flex-1");
		layout.getChildren().add(row);

		Form form = new Form();
		form.getClassNames().add(GridLayout.COL_LG);
		row.getChildren().add(form);

		InputElement input = new InputElement();
		input.setLabel("Input Label");
		input.setId("email");
		form.getChildren().add(input);

		input = new InputElement();
		input.setLabel("Password");
		input.setId("passwd");
		input.setType(Type.PASSWORD);
		form.getChildren().add(input);

		TextArea textArea = new TextArea();
		textArea.setLabel("Comments");
		textArea.setId("comments");
		form.getChildren().add(textArea);

		input = new InputElement();
		input.setType(Type.FILE);
		form.getChildren().add(input);

		input = new InputElement();
		form.getChildren().add(input);
		
		FieldSet fieldSet = new FieldSet();
		fieldSet.setLegend("Radio Buttons");
		form.getChildren().add(fieldSet);

		RadioButton radio = new RadioButton();
		radio.setLabel("Lala alalal lalal");
		radio.setName("radio-name");
		fieldSet.getChildren().add(radio);

		radio = new RadioButton();
		radio.setLabel("Lala alalal lalal");
		radio.setName("radio-name");
		fieldSet.getChildren().add(radio);

		CheckBox checkBox = new CheckBox();
		checkBox.setLabel("Lala alalal lalal");
		form.getChildren().add(checkBox);
	}

	public static void xxmain(String[] args) throws Exception {
		Activity activity = new Activity();

		GridLayout layout = activity.getContainer();
		activity.getContainer().setFluid(false);

		GridLayoutRow row = new GridLayoutRow();
		layout.getChildren().add(row);

		PushButton btn = new PushButton("PushButton");
		btn.getClassNames().add(GridLayout.COL_SM);
		row.getChildren().add(btn);

		btn = new PushButton("PushButton");
		btn.getClassNames().add(GridLayout.COL_SM);
		row.getChildren().add(btn);

		row = new GridLayoutRow();
		row.getClassNames().add("flex-1");
		layout.getChildren().add(row);

		btn = new PushButton("PushButton");
		btn.getClassNames().add(GridLayout.COL_SM);
		btn.getClassNames().add(GridLayout.COL_SM_ALIGN_TOP);
		row.getChildren().add(btn);

		btn = new PushButton("PushButton");
		btn.getClassNames().add(GridLayout.COL_SM);
		btn.getClassNames().add(GridLayout.COL_SM_ALIGN_BOTTOM);
		row.getChildren().add(btn);
	}

	public static void xmain(String[] args) throws Exception {

		Label label = new Label();
		label.setText("A Label");
		label.setLabeledControlId("lala");

		PushButton btn1 = new PushButton();
		btn1.setText("Click me!!!");
		btn1.setId("lala");
		btn1.addEventListener("click", new EventListener() {
			@Override
			public void handleEvent(Event evt) {
				Global.window.alert("btn1 clicked!!!");
			}
		}, false);

		PushButton btn2 = new PushButton("Click me!!! #2");
		btn2.getClassNames().add("lala");

		Activity activity = new Activity();
		GridLayout layout = activity.getContainer();
		activity.getContainer().setFluid(false);

		GridLayoutRow row = new GridLayoutRow();
		layout.getChildren().add(row);

		row.getChildren().add(btn1);
		row.getChildren().add(btn2);
	}
}