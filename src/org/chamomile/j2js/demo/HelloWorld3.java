package org.chamomile.j2js.demo;

import org.chamomile.widgets.Window;
import org.chamomile.widgets.CheckBox;
import org.chamomile.widgets.FieldSet;
import org.chamomile.widgets.Form;
import org.chamomile.widgets.GridLayout;
import org.chamomile.widgets.GridLayoutRow;
import org.chamomile.widgets.InputElement;
import org.chamomile.widgets.InputElement.Type;
import org.chamomile.widgets.Label;
import org.chamomile.widgets.Nav;
import org.chamomile.widgets.NavItemAnchor;
import org.chamomile.widgets.Dropdown2;
import org.chamomile.widgets.Navbar;
import org.chamomile.widgets.NavbarBrand;
import org.chamomile.widgets.PushButton;
import org.chamomile.widgets.RadioButton;
import org.chamomile.widgets.TextArea;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;

import j2js.Global;

public class HelloWorld3 {
	
	public static void main(String[] args) throws Exception {
		Window window = new Window();
		window.setFluid(true);
		
		GridLayoutRow row = new GridLayoutRow();
		window.getChildren().add(row);
		
		Navbar navbar = new Navbar();
		navbar.getClassNames().add(GridLayout.COL_XS);
		row.getChildren().add(navbar);
		
		NavbarBrand brand = new NavbarBrand();
		brand.setHTML("<img src=\"http://v4-alpha.getbootstrap.com/assets/brand/bootstrap-solid.svg\" width=\"30\" height=\"30\" class=\"d-inline-block align-top\"> Chamomile");
		navbar.getChildren().add(brand);
		
		Nav nav = new Nav();
		navbar.getChildren().add(nav);
		
		NavItemAnchor item = new NavItemAnchor();
		item.setText("Active");
		nav.getChildren().add(item);
		
		item = new NavItemAnchor();
		item.setText("Link");
		nav.getChildren().add(item);
		
		item = new NavItemAnchor();
		item.setText("Link");
		nav.getChildren().add(item);

		item = new NavItemAnchor();
		item.setText("Link");
		nav.getChildren().add(item);
		
		Dropdown2 dropdown = new Dropdown2();
		dropdown.setText("Dropdown");
		nav.getChildren().add(dropdown);
	}

	public static void xxxmain(String[] args) throws Exception {
		Window window = new Window();
		window.setFluid(true);

		GridLayoutRow row = new GridLayoutRow();
		row.getClassNames().add("flex-1");
		window.getChildren().add(row);

		Form form = new Form();
		form.getClassNames().add(GridLayout.COL_LG);
		row.getChildren().add(form);

		InputElement input = new InputElement();
		input.setLabel("Input Label");
		input.setId("email");
		input.getClassNames().add(GridLayout.COL_LG);
		form.getChildren().add(input);

		input = new InputElement();
		input.setLabel("Password");
		input.setId("passwd1");
		input.setType(Type.PASSWORD);
		input.getClassNames().add(GridLayout.COL_LG);
		form.getChildren().add(input);

		input = new InputElement();
		input.setLabel("Password");
		input.setId("passwd2");
		input.setType(Type.PASSWORD);
		input.getClassNames().add(GridLayout.COL_LG);
		form.getChildren().add(input);

		input = new InputElement();
		input.setLabel("Password");
		input.setId("passwd3");
		input.setType(Type.PASSWORD);
		input.getClassNames().add(GridLayout.COL_LG);
		form.getChildren().add(input);

		input = new InputElement();
		input.setLabel("Password");
		input.setId("passwd4");
		input.setType(Type.PASSWORD);
		input.getClassNames().add(GridLayout.COL_LG);
		form.getChildren().add(input);

		TextArea textArea = new TextArea();
		textArea.setLabel("Comments");
		textArea.setId("comments");
		textArea.getClassNames().add(GridLayout.COL_LG);
		form.getChildren().add(textArea);

		input = new InputElement();
		input.setType(Type.FILE);
		input.getClassNames().add(GridLayout.COL_LG);
		form.getChildren().add(input);

		input = new InputElement();
		input.getClassNames().add(GridLayout.COL_LG);
		form.getChildren().add(input);
		
		FieldSet fieldSet = new FieldSet();
		fieldSet.setLegend("Radio Buttons");
		fieldSet.getClassNames().add(GridLayout.COL_LG);
		form.getChildren().add(fieldSet);

		RadioButton radio = new RadioButton();
		radio.setLabel("Lala alalal lalal");
		radio.setName("radio-name");
		radio.getClassNames().add(GridLayout.COL_LG);
		fieldSet.getChildren().add(radio);

		radio = new RadioButton();
		radio.setLabel("Lala alalal lalal");
		radio.setName("radio-name");
		radio.getClassNames().add(GridLayout.COL_LG);
		fieldSet.getChildren().add(radio);

		CheckBox checkBox = new CheckBox();
		checkBox.setLabel("Lala alalal lalal");
		checkBox.getClassNames().add(GridLayout.COL_LG);
		form.getChildren().add(checkBox);
	}

	public static void xxmain(String[] args) throws Exception {
		Window layout = new Window();
		layout.setFluid(false);

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

		Window activity = new Window();
		activity.setFluid(false);

		GridLayoutRow row = new GridLayoutRow();
		activity.getChildren().add(row);

		row.getChildren().add(btn1);
		row.getChildren().add(btn2);
	}
}