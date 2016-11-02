package org.chamomile.collections;

import java.util.ArrayList;
import java.util.List;

import org.chamomile.util.ListenerList;

public interface ObservableList<E> extends Sequence<E> {

	public static class ListListenerList<E> extends ListenerList<ListListener<E>>
			implements ListListener<E> {

		@Override
		public void itemInserted(ObservableList<E> list, int index) {
			for (ListListener<E> listener : this) {
				listener.itemInserted(list, index);
			}
		}

		@Override
		public void itemsRemoved(ObservableList<E> list, int index, Sequence<E> items) {
			for (ListListener<E> listener : this) {
				listener.itemsRemoved(list, index, items);
			}
		}

		@Override
		public void itemUpdated(ObservableList<E> list, int index, E previousItem) {
			for (ListListener<E> listener : this) {
				listener.itemUpdated(list, index, previousItem);
			}
		}

		@Override
		public void listCleared(ObservableList<E> list) {
			for (ListListener<E> listener : this) {
				listener.listCleared(list);
			}
		}
	}

	ListenerList<ListListener<E>> getListListeners();

	// ---

	@SuppressWarnings("unchecked")
	public static <E> ObservableList<E> create(final List<E> list) {
		if (list instanceof ObservableList) {
			return (ObservableList<E>) list;
		}

		return new AbstractList<E>() {

			@Override
			public E get(int index) {
				return list.get(index);
			}

			@Override
			public int indexOf(E item) {
				return list.indexOf(item);
			}

			@Override
			public int getLength() {
				return list.size();
			}

			@Override
			protected int addImpl(E item) {
				int index = list.size();
				list.add(item);
				return index;
			}

			@Override
			protected void insertImpl(E item, int index) {
				list.add(index, item);
			}

			@Override
			protected E updateImpl(int index, E item) {
				return list.set(index, item);
			}

			@Override
			protected Sequence<E> removeImpl(int index, int count) {
				Sequence<E> result = create(new ArrayList<E>());
				for (int i = index; i < count; i++) {
					result.add(list.remove(i));
				}
				return result;
			}

			@Override
			protected void clearImpl() {
				list.clear();
			}
		};
	}
}
