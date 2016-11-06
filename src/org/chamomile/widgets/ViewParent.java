package org.chamomile.widgets;

import org.chamomile.collections.Sequence;

public interface ViewParent<T extends View> extends View {
	
	<S extends Sequence<T>> S getChildren();
	
}
