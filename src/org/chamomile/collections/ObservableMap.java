package org.chamomile.collections;

import java.util.Map;

import org.chamomile.util.ListenerList;

public interface ObservableMap<K, V> extends Dictionary<K, V> {

	public static class MapListenerList<K, V>
			extends ListenerList<MapListener<K, V>> implements MapListener<K, V> {
		@Override
		public void valueAdded(ObservableMap<K, V> map, K key) {
			for (MapListener<K, V> listener : this) {
				listener.valueAdded(map, key);
			}
		}

		@Override
		public void valueUpdated(ObservableMap<K, V> map, K key, V previousValue) {
			for (MapListener<K, V> listener : this) {
				listener.valueUpdated(map, key, previousValue);
			}
		}

		@Override
		public void valueRemoved(ObservableMap<K, V> map, K key, V value) {
			for (MapListener<K, V> listener : this) {
				listener.valueRemoved(map, key, value);
			}
		}

		@Override
		public void mapCleared(ObservableMap<K, V> map) {
			for (MapListener<K, V> listener : this) {
				listener.mapCleared(map);
			}
		}
	}

	void clear();

	int getCount();

	ListenerList<MapListener<K, V>> getMapListeners();

	// ---

	@SuppressWarnings("unchecked")
	public static <K, V> ObservableMap<K, V> create(final Map<K, V> map) {
		if (map instanceof ObservableMap) {
			return (ObservableMap<K, V>) map;
		}
		
		return new AbstractMap<K, V>() {

			@Override
			public V get(K key) {
				return map.get(key);
			}

			@Override
			protected V putImpl(K key, V value) {
				V previousValue = map.get(key);
				map.put(key, value);
				return previousValue;
			}

			@Override
			protected V removeImpl(K key) {
				V previousValue = map.get(key);
				map.remove(key);
				return previousValue;
			}

			@Override
			public boolean containsKey(K key) {
				return map.containsKey(key);
			}

			@Override
			protected void clearImpl() {
				map.clear();
			}

			@Override
			public int getCount() {
				return map.size();
			}
		};
	}
}
