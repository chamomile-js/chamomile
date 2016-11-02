package org.chamomile.collections;

import org.chamomile.util.ListenerList;

public abstract class AbstractMap<K, V> implements ObservableMap<K, V> {
	private transient MapListenerList<K, V> mapListeners = null;

	@Override
	public V put(K key, V value) {
		boolean update = containsKey(key);
		V previousValue = putImpl(key, value);

		if (update) {
			if (previousValue != value) {
				if (mapListeners != null) {
					mapListeners.valueUpdated(this, key, previousValue);
				}
			}
		} else {
			if (mapListeners != null) {
				mapListeners.valueAdded(this, key);
			}
		}

		return previousValue;
	}

	protected abstract V putImpl(K key, V value);

	@Override
	public V remove(K key) {
		V value = null;

		if (containsKey(key)) {
			value = removeImpl(key);
			if (mapListeners != null) {
				mapListeners.valueRemoved(this, key, value);
			}
		}

		return value;
	}

	protected abstract V removeImpl(K key);

	@Override
	public void clear() {
		if (getCount() > 0) {
			clearImpl();
			if (mapListeners != null) {
				mapListeners.mapCleared(this);
			}
		}
	}
	
	protected abstract void clearImpl();

	@Override
	public ListenerList<MapListener<K, V>> getMapListeners() {
		if (mapListeners == null) {
			mapListeners = new MapListenerList<K, V>();
		}
		return mapListeners;
	}
}
