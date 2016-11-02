package org.chamomile.collections;

public interface ListListener<E> {

	/** Map listener adapter. */
	public static class Adapter<E> implements ListListener<E> {
		@Override
		public void itemInserted(ObservableList<E> list, int index) {
			// empty block
		}

		@Override
		public void itemsRemoved(ObservableList<E> list, int index, Sequence<E> items) {
			// empty block
		}

		@Override
		public void itemUpdated(ObservableList<E> list, int index, E previousItem) {
			// empty block
		}

		@Override
		public void listCleared(ObservableList<E> list) {
			// empty block
		}
	}

	// TODO itemsInserted
	void itemInserted(ObservableList<E> list, int index);

	void itemsRemoved(ObservableList<E> list, int index, Sequence<E> items);

	void itemUpdated(ObservableList<E> list, int index, E previousItem);

	void listCleared(ObservableList<E> list);

}
