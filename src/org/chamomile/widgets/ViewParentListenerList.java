package org.chamomile.widgets;

import org.chamomile.collections.Sequence;
import org.chamomile.util.ListenerList;

public class ViewParentListenerList<T extends View> extends ListenerList<ViewParentListener<T>>
		implements ViewParentListener<T> {
	@Override
	public void viewInserted(ViewParent<T> parent, int index) {
		for (ViewParentListener<T> listener : this) {
			listener.viewInserted(parent, index);
		}
	}

	@Override
	public void viewsRemoved(ViewParent<T> parent, int index, Sequence<T> views) {
		for (ViewParentListener<T> listener : this) {
			listener.viewsRemoved(parent, index, views);
		}
	}

	@Override
	public void viewMoved(ViewParent<T> parent, int from, int to) {
		for (ViewParentListener<T> listener : this) {
			listener.viewMoved(parent, from, to);
		}
	}
}