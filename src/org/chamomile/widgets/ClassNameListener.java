package org.chamomile.widgets;

import org.chamomile.collections.Sequence;

public interface ClassNameListener {

	void classNameInserted(Component component, int index);

	void classNamesRemoved(Component component, int index,
			Sequence<String> classNames);
}
