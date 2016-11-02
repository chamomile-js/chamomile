package org.chamomile.j2js.demo;

import org.chamomile.widgets.Activity;
import org.chamomile.widgets.GridLayout;
import org.chamomile.widgets.GridLayoutRow;
import org.chamomile.widgets.Label;
import org.chamomile.widgets.PushButton;

import j2js.Global;
import j2js.w3c.dom.events.Event;
import j2js.w3c.dom.events.EventListener;

public class HelloWorld1 {
	
	public static void main(String[] args) throws Exception {
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