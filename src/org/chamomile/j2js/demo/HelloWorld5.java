package org.chamomile.j2js.demo;

import org.chamomile.widgets.GridLayout;
import org.chamomile.widgets.GridLayoutRow;
import org.chamomile.widgets.ListGroup;
import org.chamomile.widgets.ListGroupActionItem;
import org.chamomile.widgets.ListGroupAnchorItem;
import org.chamomile.widgets.ListGroupTextItem;
import org.chamomile.widgets.SemanticStyle;
import org.chamomile.widgets.Tag;
import org.chamomile.widgets.Window;

public class HelloWorld5 {

	public static void main(String[] args) throws Exception {
		
		ListGroup listGroup = new ListGroup();
		
		ListGroupAnchorItem item = new ListGroupAnchorItem();
		item.setText("Item " + item.hashCode());
		item.getChildren().add(new Tag("NEW"));
		//item.setTagSemanticStyle(SemanticStyle.INFO);
		//item.setSemanticStyle(SemanticStyle.DANGER);
		listGroup.getChildren().add(item);
		
		item = new ListGroupAnchorItem();
		item.setText("Item " + item.hashCode());
		listGroup.getChildren().add(item);
		
		item = new ListGroupAnchorItem();
		item.setText("Item " + item.hashCode());
		listGroup.getChildren().add(item);
		
		item = new ListGroupAnchorItem();
		item.setText("Item " + item.hashCode());
		listGroup.getChildren().add(item);
		
		ListGroupActionItem item2 = new ListGroupActionItem();
		item2.setText("Item " + item2.hashCode());
		listGroup.getChildren().add(item2);
		
		item2 = new ListGroupActionItem();
		item2.setText("Item " + item2.hashCode());
		listGroup.getChildren().add(item2);
		
		item2 = new ListGroupActionItem();
		item2.getChildren().add(new Tag("XXX", SemanticStyle.INFO, true));
		item2.getChildren().add(new Tag("New", SemanticStyle.OUTLINE_DANGER, true));
		item2.setText("Item " + item2.hashCode());
		listGroup.getChildren().add(item2);
		
		item2 = new ListGroupActionItem();
		item2.setText("Item " + item2.hashCode());
		listGroup.getChildren().add(item2);
		
		ListGroupTextItem item3 = new ListGroupTextItem();
		item3.setText("Item " + item3.hashCode());
		listGroup.getChildren().add(item3);

		// ---

		Window window = new Window();
		window.setFluid(false);

		GridLayoutRow row = new GridLayoutRow();
		window.getChildren().add(row);
		row.getClassNames().add("flex-1");

		row.getChildren().add(listGroup);
		listGroup.getClassNames().add(GridLayout.COL_XS);
	}
}