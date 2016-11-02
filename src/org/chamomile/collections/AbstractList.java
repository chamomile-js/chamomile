package org.chamomile.collections;

import org.chamomile.util.ListenerList;

public abstract class AbstractList<E> implements ObservableList<E> {
	private ListListenerList<E> listListeners = null;

	@Override
	public ListenerList<ListListener<E>> getListListeners() {
		if (listListeners == null) {
			listListeners = new ListListenerList<E>();
		}
		return listListeners;
	}

	@Override
	public int add(E item) {
		int index = addImpl(item);
		if (listListeners != null) {
			listListeners.itemInserted(this, index);
		}
		return index;
	}

	protected abstract int addImpl(E item);

	@Override
	public void insert(E item, int index) {
		insertImpl(item, index);
		if (listListeners != null) {
			listListeners.itemInserted(this, index);
		}
	}

	protected abstract void insertImpl(E item, int index);

	@Override
	public E update(int index, E item) {
		E previousItem = updateImpl(index, item);
		if (previousItem != item) {
			if (listListeners != null) {
				listListeners.itemUpdated(this, index, previousItem);
			}
		}
		return previousItem;
	}

	protected abstract E updateImpl(int index, E item);

	@Override
	public int remove(E item) {
		int index = indexOf(item);
		if (index != -1) {
			remove(index, 1);
		}
		return index;
	}

	@Override
	public Sequence<E> remove(int index, int count) {
		Sequence<E> removed = removeImpl(index, count);
		if (removed.getLength() > 0) {
			if (listListeners != null) {
				listListeners.itemsRemoved(this, index, removed);
			}
		}
		return removed;
	}

	protected abstract Sequence<E> removeImpl(int index, int count);

	@Override
	public void clear() {
		if (getLength() > 0) {
			clearImpl();
			if (listListeners != null) {
				listListeners.listCleared(this);
			}
		}
	}

	protected abstract void clearImpl();
}
