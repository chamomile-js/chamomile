package org.chamomile.widgets;

import org.chamomile.collections.Sequence;

/**
 * {@link ViewParent} listener interface.
 */
public interface ViewParentListener<T extends View> {

	void viewInserted(ViewParent<T> parent, int index);

	void viewsRemoved(ViewParent<T> parent, int index, Sequence<T> removed);

	void viewMoved(ViewParent<T> parent, int from, int to);
}