package org.chamomile.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface representing an ordered sequence of items.
 *
 * @param <E>
 */
public interface Sequence<E> {

	int add(E item);

	void insert(E item, int index);

	E update(int index, E item);

	int remove(E item);

	Sequence<E> remove(int index, int count);

	E get(int index);

	int indexOf(E item);

	int getLength();

	void clear();

	// ---

	@SuppressWarnings("unchecked")
	public static <E> Sequence<E> create(final List<E> list) {
		if (list instanceof Sequence) {
			return (Sequence<E>) list;
		}

		return new Sequence<E>() {

			@Override
			public int add(E item) {
				int index = list.size();
				list.add(item);
				return index;
			}

			@Override
			public void insert(E item, int index) {
				list.add(index, item);
			}

			@Override
			public E update(int index, E item) {
				return list.set(index, item);
			}

			@Override
			public int remove(E item) {
				int index = list.indexOf(item);
				list.remove(index);
				return index;
			}

			@Override
			public Sequence<E> remove(int index, int count) {
				Sequence<E> result = create(new ArrayList<E>());
				for (int i = index; i < count; i++) {
					result.add(list.remove(i));
				}
				return result;
			}

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
			public void clear() {
				list.clear();
			}
		};
	}
}
