package org.chamomile.j2js.demo;

import org.chamomile.widgets.GridLayoutRow;
import org.chamomile.widgets.PushButton;
import org.chamomile.widgets.SemanticStyle;
import org.chamomile.widgets.SizeStyle;
import org.chamomile.widgets.Window;

public class HelloWorld1 {

	public static void main(String[] args) throws Exception {
		Window window = new Window();
		//window.setFluid(true);

		GridLayoutRow row = new GridLayoutRow();
		window.getChildren().add(row);
		row.getClassNames().add("flex-1");
		//row.getClassNames().add(GridLayout.ROW_XS_ALIGN_MIDDLE);
		
		PushButton btn = new PushButton();
		btn.setText("Default");
    //btn.getClassNames().add(GridLayout.COL_XS);
    //btn.setSizeStyle(SizeStyle.SAMALLER);
		btn.setSemanticStyle(SemanticStyle.OUTLINE_INFO);
		btn.setBlockLevel(true);
		
		row.getChildren().add(btn);
		
		btn = new PushButton();
    btn.setText("Smaller");
    //btn.getClassNames().add(GridLayout.COL_XS);
    btn.setSizeStyle(SizeStyle.SMALLER);
    btn.setSemanticStyle(SemanticStyle.OUTLINE_PRIMARY);
    btn.setBlockLevel(true);
    
    row.getChildren().add(btn);
    
    btn = new PushButton();
    btn.setText("Larger");
    //btn.getClassNames().add(GridLayout.COL_XS);
    btn.setSizeStyle(SizeStyle.LARGER);
    btn.setSemanticStyle(SemanticStyle.OUTLINE_SUCCESS);
    btn.setBlockLevel(true);
    
    row.getChildren().add(btn);
	}
}