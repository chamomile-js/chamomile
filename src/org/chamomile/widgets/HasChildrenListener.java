package org.chamomile.widgets;

import org.chamomile.collections.Sequence;

/**
 * Container listener interface.
 */
public interface ContainerListener<T extends Component> {

	void viewInserted(Container<T> container, int index);

	void viewRemoved(Container<T> container, int index, Sequence<T> removed);

	void viewMoved(Container<T> container, int from, int to);

}