package org.chamomile.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * Interface representing a set of key/value pairs.
 *
 * @param <K>
 * @param <V>
 */
public interface Dictionary<K, V> {

	V get(K key);

	V put(K key, V value);

	V remove(K key);

	boolean containsKey(K key);

	static <K, V> Dictionary<K, V> create() {
		return create(new HashMap<K, V>());
	}

	@SuppressWarnings("unchecked")
	static <K, V> Dictionary<K, V> create(final Map<K, V> hashMap) {
		if (hashMap instanceof Dictionary) {
			return (Dictionary<K, V>) hashMap;
		}

		return new Dictionary<K, V>() {
			@Override
			public V get(K key) {
				return hashMap.get(key);
			}

			@Override
			public V put(K key, V value) {
				V previousValue = hashMap.get(key);
				hashMap.put(key, value);
				return previousValue;
			}

			@Override
			public V remove(K key) {
				return hashMap.remove(key);
			}

			@Override
			public boolean containsKey(K key) {
				return hashMap.containsKey(key);
			}
		};
	}

}