package org.chamomile.j2js.demo;

import static j2js.Global.window;

import org.chamomile.widgets.Dropdown2;
import org.chamomile.widgets.GridLayoutRow;
import org.chamomile.widgets.Menu;
import org.chamomile.widgets.MenuItemAnchor;
import org.chamomile.widgets.SemanticStyle;
import org.chamomile.widgets.Separator;
import org.chamomile.widgets.SizeStyle;
import org.chamomile.widgets.SplitButton;
import org.chamomile.widgets.Window;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;

public class HelloWorld4 {

	public static void main(String[] args) throws Exception {

		Dropdown2 dropdown = new Dropdown2();
		dropdown.setText("Dropdown");
		dropdown.setSemanticStyle(SemanticStyle.OUTLINE_PRIMARY);
		dropdown.setSizeStyle(SizeStyle.SMALLER);

		Menu menu = new Menu();
		dropdown.setMenu(menu);

		MenuItemAnchor item = new MenuItemAnchor();
		item.setText("Action");
		menu.getChildren().add(item);

		item = new MenuItemAnchor();
		item.setText("Another action");
		menu.getChildren().add(item);

		item = new MenuItemAnchor();
		item.setText("Something else here");
		menu.getChildren().add(item);

		menu.getChildren().add(new Separator());

		item = new MenuItemAnchor();
		item.setText("Separated link");
		menu.getChildren().add(item);

		SplitButton splitBtn = new SplitButton();
		splitBtn.setText("Success");
		splitBtn.setSemanticStyle(SemanticStyle.SUCCESS);
		splitBtn.setMenu(menu);
		
		EventListener l;

		splitBtn.addEventListener("click", l = new EventListener() {
			@Override
			public void handleEvent(Event evt) {
				window.alert("cliecked");
			}
		}, false);
		
		splitBtn.removeEventListener("click", l, false);

		// ---

		Window window = new Window();
		window.setFluid(false);

		GridLayoutRow row = new GridLayoutRow();
		window.getChildren().add(row);
		// row.getClassNames().add("flex-1");

		row.getChildren().add(dropdown);
		//row.getChildren().add(splitBtn);
	}
}