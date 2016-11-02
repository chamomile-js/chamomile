package org.chamomile.collections;

public interface MapListener<K, V> {

	public static class Adapter<K, V> implements MapListener<K, V> {
		@Override
		public void valueAdded(ObservableMap<K, V> map, K key) {
			// empty block
		}

		@Override
		public void valueUpdated(ObservableMap<K, V> map, K key, V previousValue) {
			// empty block
		}

		@Override
		public void valueRemoved(ObservableMap<K, V> map, K key, V value) {
			// empty block
		}

		@Override
		public void mapCleared(ObservableMap<K, V> map) {
			// empty block
		}
	}

	void valueAdded(ObservableMap<K, V> map, K key);

	void valueUpdated(ObservableMap<K, V> map, K key, V previousValue);

	void valueRemoved(ObservableMap<K, V> map, K key, V value);

	void mapCleared(ObservableMap<K, V> map);
	
}
