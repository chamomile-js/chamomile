package org.chamomile.widgets;

import org.chamomile.collections.Sequence;
import org.chamomile.util.ListenerList;

public class HasChildrenListenerList<T extends Component> extends ListenerList<HasChildrenListener<T>>
		implements HasChildrenListener<T> {
	@Override
	public void componentInserted(HasChildren<T> container, int index) {
		for (HasChildrenListener<T> listener : this) {
			listener.componentInserted(container, index);
		}
	}

	@Override
	public void componentsRemoved(HasChildren<T> container, int index, Sequence<T> views) {
		for (HasChildrenListener<T> listener : this) {
			listener.componentsRemoved(container, index, views);
		}
	}

	@Override
	public void componentMoved(HasChildren<T> container, int from, int to) {
		for (HasChildrenListener<T> listener : this) {
			listener.componentMoved(container, from, to);
		}
	}
}