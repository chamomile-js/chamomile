package org.chamomile.widgets;

import org.chamomile.widgets.skin.DefaultDropdown2Skin;
import org.chamomile.widgets.skin.NavItemSkin;

/**
 * Dropdowns are toggleable, contextual overlays for displaying lists of links
 * and more. They're toggled by clicking, not by hovering; this is
 * <a href="http://markdotto.com/2012/02/27/bootstrap-explained-dropdowns/">an
 * intentional design decision</a>.
 * 
 * @author ggeorg
 */
public class Dropdown2 extends NavItemAnchor implements HashMenuProperty,
		HasSemanticStyleProperty, HasSizeStyleProperty {

	public Dropdown2() {
		this(new DefaultDropdown2Skin());
	}

	public Dropdown2(NavItemSkin skin) {
		super(skin);
	}

	@Override
	public Menu getMenu() {
		return (Menu) get(MENU);
	}

	@Override
	public void setMenu(Menu menu) {
		put(MENU, menu);
	}

	@Override
	public SemanticStyle getSemanticStyle() {
		return (SemanticStyle) get(SEMANTIC_STYLE);
	}

	@Override
	public void setSemanticStyle(SemanticStyle style) {
		put(SEMANTIC_STYLE, style);
	}

	@Override
	public SizeStyle getSizeStyle() {
		return (SizeStyle) get(SIZE_STYLE);
	}

	@Override
	public void setSizeStyle(SizeStyle style) {
		put(SIZE_STYLE, style);
	}
}
