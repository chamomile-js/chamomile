package org.chamomile.widgets;

import org.chamomile.collections.Sequence;

/**
 * Container listener interface.
 */
public interface HasChildrenListener<T extends Component> {

	void componentInserted(HasChildren<T> container, int index);

	void componentsRemoved(HasChildren<T> container, int index, Sequence<T> removed);

	void componentMoved(HasChildren<T> container, int from, int to);
}