package org.chamomile.widgets;

import org.chamomile.collections.Sequence;

public interface HasChildren<T extends Component> {
	<S extends Sequence<T>> S getChildren();

	boolean isAncestor(HasChildren<?> container);

	void descendantRemoved(Component component);

	void descendantAdded(Component component);
}
