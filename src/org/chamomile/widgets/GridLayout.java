package org.chamomile.widgets;

import org.chamomile.widgets.skin.DefaultGridLayoutSkin;

/**
 * A powerful mobile-first grid system for building layouts of all shapes and
 * sizes. It's based on a 12 column layout and has multiple tiers, one for each
 * media query range.
 * 
 * @author ggeorg
 */
public class GridLayout extends Container<GridLayoutRow> {
	
	//
	// Extra Small (< 576px)
	//
	
	public static final String COL_XS_1 = "col-xs-1";
	public static final String COL_XS_2 = "col-xs-2";
	public static final String COL_XS_3 = "col-xs-3";
	public static final String COL_XS_4 = "col-xs-4";
	public static final String COL_XS_5 = "col-xs-5";
	public static final String COL_XS_6 = "col-xs-6";
	public static final String COL_XS_7 = "col-xs-7";
	public static final String COL_XS_8 = "col-xs-8";
	public static final String COL_XS_9 = "col-xs-9";
	public static final String COL_XS_10 = "col-xs-10";
	public static final String COL_XS_11 = "col-xs-11";
	public static final String COL_XS_12 = "col-xs-12";
	
	//
	// Small (>= 576px)
	//
	
	public static final String COL_SM_1 = "col-sm-1";
	public static final String COL_SM_2 = "col-sm-2";
	public static final String COL_SM_3 = "col-sm-3";
	public static final String COL_SM_4 = "col-sm-4";
	public static final String COL_SM_5 = "col-sm-5";
	public static final String COL_SM_6 = "col-sm-6";
	public static final String COL_SM_7 = "col-sm-7";
	public static final String COL_SM_8 = "col-sm-8";
	public static final String COL_SM_9 = "col-sm-9";
	public static final String COL_SM_10 = "col-sm-10";
	public static final String COL_SM_11 = "col-sm-11";
	public static final String COL_SM_12 = "col-sm-12";
	
	//
	// Medium (>= 768px)
	//
	
	public static final String COL_MD_1 = "col-md-1";
	public static final String COL_MD_2 = "col-md-2";
	public static final String COL_MD_3 = "col-md-3";
	public static final String COL_MD_4 = "col-md-4";
	public static final String COL_MD_5 = "col-md-5";
	public static final String COL_MD_6 = "col-md-6";
	public static final String COL_MD_7 = "col-md-7";
	public static final String COL_MD_8 = "col-md-8";
	public static final String COL_MD_9 = "col-md-9";
	public static final String COL_MD_10 = "col-md-10";
	public static final String COL_MD_11 = "col-md-11";
	public static final String COL_MD_12 = "col-md-12";
	
	//
	// Large (>= 992px)
	//
	
	public static final String COL_LG_1 = "col-lg-1";
	public static final String COL_LG_2 = "col-lg-2";
	public static final String COL_LG_3 = "col-lg-3";
	public static final String COL_LG_4 = "col-lg-4";
	public static final String COL_LG_5 = "col-lg-5";
	public static final String COL_LG_6 = "col-lg-6";
	public static final String COL_LG_7 = "col-lg-7";
	public static final String COL_LG_8 = "col-lg-8";
	public static final String COL_LG_9 = "col-lg-9";
	public static final String COL_LG_10 = "col-lg-10";
	public static final String COL_LG_11 = "col-lg-11";
	public static final String COL_LG_12 = "col-lg-12";
	
	//
	// Extra Large (>= 1200px)
	//
	
	public static final String COL_XL_1 = "col-xl-1";
	public static final String COL_XL_2 = "col-xl-2";
	public static final String COL_XL_3 = "col-xl-3";
	public static final String COL_XL_4 = "col-xl-4";
	public static final String COL_XL_5 = "col-xl-5";
	public static final String COL_XL_6 = "col-xl-6";
	public static final String COL_XL_7 = "col-xl-7";
	public static final String COL_XL_8 = "col-xl-8";
	public static final String COL_XL_9 = "col-xl-9";
	public static final String COL_XL_10 = "col-xl-10";
	public static final String COL_XL_11 = "col-xl-11";
	public static final String COL_XL_12 = "col-xl-12";
	
	//
	// Auto-layout columns (for equal-width columns)
	//

	public static final String COL_XS = "col-xs";
	public static final String COL_SM = "col-sm";
	public static final String COL_MD = "col-md";
	public static final String COL_LG = "col-lg";
	public static final String COL_XL = "col-xl";
	
	//
	// Vertical alignment (row)
	//
	
	public static final String ROW_XS_ALIGN_TOP = "flex-items-xs-top";
	public static final String ROW_XS_ALIGN_MIDDLE = "flex-items-xs-middle";
	public static final String ROW_XS_ALIGN_BOTTOM = "flex-items-xs-bottom";
	
	public static final String ROW_SM_ALIGN_TOP = "flex-items-sm-top";
	public static final String ROW_SM_ALIGN_MIDDLE = "flex-items-sm-middle";
	public static final String ROW_SM_ALIGN_BOTTOM = "flex-items-sm-bottom";
	
	public static final String ROW_MD_ALIGN_TOP = "flex-items-md-top";
	public static final String ROW_MD_ALIGN_MIDDLE = "flex-items-md-middle";
	public static final String ROW_MD_ALIGN_BOTTOM = "flex-items-md-bottom";
	
	public static final String ROW_LG_ALIGN_TOP = "flex-items-lg-top";
	public static final String ROW_LG_ALIGN_MIDDLE = "flex-items-lg-middle";
	public static final String ROW_LG_ALIGN_BOTTOM = "flex-items-lg-bottom";

	public static final String ROW_XL_ALIGN_TOP = "flex-items-xl-top";
	public static final String ROW_XL_ALIGN_MIDDLE = "flex-items-xl-middle";
	public static final String ROW_XL_ALIGN_BOTTOM = "flex-items-xl-bottom";

	//
	// Vertical alignment (column)
	//
	
	public static final String COL_XS_ALIGN_TOP = "flex-xs-top";
	public static final String COL_XS_ALIGN_MIDDLE = "flex-xs-middle";
	public static final String COL_XS_ALIGN_BOTTOM = "flex-xs-bottom";
	
	public static final String COL_SM_ALIGN_TOP = "flex-sm-top";
	public static final String COL_SM_ALIGN_MIDDLE = "flex-sm-middle";
	public static final String COL_SM_ALIGN_BOTTOM = "flex-sm-bottom";
	
	public static final String COL_MD_ALIGN_TOP = "flex-md-top";
	public static final String COL_MD_ALIGN_MIDDLE = "flex-md-middle";
	public static final String COL_MD_ALIGN_BOTTOM = "flex-md-bottom";
	
	public static final String COL_LG_ALIGN_TOP = "flex-lg-top";
	public static final String COL_LG_ALIGN_MIDDLE = "flex-lg-middle";
	public static final String COL_LG_ALIGN_BOTTOM = "flex-lg-bottom";

	public static final String COL_XL_ALIGN_TOP = "flex-xl-top";
	public static final String COL_XL_ALIGN_MIDDLE = "flex-xl-middle";
	public static final String COL_XL_ALIGN_BOTTOM = "flex-xl-bottom";
	
	//
	// Horizontal alignment (row)
	//
	
	public static final String ROW_XS_ALIGN_LEFT = "flex-items-xs-left";
	public static final String ROW_XS_ALIGN_CENTER = "flex-items-xs-center";
	public static final String ROW_XS_ALIGN_RIGHT = "flex-items-xs-right";
	public static final String ROW_XS_ALIGN_AROUND = "flex-items-xs-around";
	public static final String ROW_XS_ALIGN_BETWEEN = "flex-items-xs-between";
	
	public static final String ROW_SM_ALIGN_LEFT = "flex-items-sm-left";
	public static final String ROW_SM_ALIGN_CENTER = "flex-items-sm-center";
	public static final String ROW_SM_ALIGN_RIGHT = "flex-items-sm-right";
	public static final String ROW_SM_ALIGN_AROUND = "flex-items-sm-around";
	public static final String ROW_SM_ALIGN_BETWEEN = "flex-items-sm-between";
	
	public static final String ROW_MD_ALIGN_LEFT = "flex-items-md-left";
	public static final String ROW_MD_ALIGN_CENTER = "flex-items-md-center";
	public static final String ROW_MD_ALIGN_RIGHT = "flex-items-md-right";
	public static final String ROW_MD_ALIGN_AROUND = "flex-items-md-around";
	public static final String ROW_MD_ALIGN_BETWEEN = "flex-items-md-between";
	
	public static final String ROW_LG_ALIGN_LEFT = "flex-items-lg-left";
	public static final String ROW_LG_ALIGN_CENTER = "flex-items-lg-center";
	public static final String ROW_LG_ALIGN_RIGHT = "flex-items-lg-right";
	public static final String ROW_LG_ALIGN_AROUND = "flex-items-lg-around";
	public static final String ROW_LG_ALIGN_BETWEEN = "flex-items-lg-between";

	public static final String ROW_XL_ALIGN_LEFT = "flex-items-xl-left";
	public static final String ROW_XL_ALIGN_CENTER = "flex-items-xl-center";
	public static final String ROW_XL_ALIGN_RIGHT = "flex-items-xl-right";
	public static final String ROW_XL_ALIGN_AROUND = "flex-items-xl-around";
	public static final String ROW_XL_ALIGN_BETWEEN = "flex-items-xl-between";
	
	//
	// Visibility utilities
	//
	
	// hidden-*-up
	// hidden-md-down
	
	//
	// Print classes
	//
	
	// ---

	public GridLayout() {
		setSkin(new DefaultGridLayoutSkin());
		setFluid(false);
	}

	/**
	 * The container's fluid property.
	 */
	public static final String FLUID = "fluid";

	public boolean isFluid() {
		return (Boolean) get(FLUID, Boolean.FALSE);
	}

	public void setFluid(boolean fluid) {
		put(FLUID, Boolean.valueOf(fluid));
	}
}
