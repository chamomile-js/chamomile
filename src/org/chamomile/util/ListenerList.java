/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.chamomile.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Abstract base class for listener lists.
 */
public class ListenerList<T> implements Iterable<T> {

	private List<T> list = new ArrayList<T>();

	/**
	 * Adds a listener to the list, if it has not previously been added.
	 *
	 * @param listener
	 */
	public void add(T listener) {
		if (list.indexOf(listener) >= 0) {
			System.err.println("Duplicate listener " + listener + " added to " + this);
			return;
		}

		list.add(listener);
	}

	/**
	 * Removes a listener from the list, if it has previously been added.
	 *
	 * @param listener
	 */
	public void remove(T listener) {
		int index = list.indexOf(listener);

		if (index < 0) {
			System.err.println("Nonexistent listener " + listener + " removed from " + this);
			return;
		}

		list.remove(index);
	}

	/**
	 * Tests the existence of a listener in the list.
	 *
	 * @param listener
	 *
	 * @return <tt>true</tt> if the listener exists in the list; <tt>false</tt>,
	 *         otherwise.
	 */
	public boolean contains(T listener) {
		return list.contains(listener);
	}

	/**
	 * Tests the emptiness of the list.
	 *
	 * @return <tt>true</tt> if the list contains no listeners; <tt>false</tt>,
	 *         otherwise.
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * Get the number of elements in the list.
	 *
	 * @return the number of elements.
	 */
	public int getLength() {
		return list.size();
	}

	/**
	 * Get the indexed element in the list.
	 *
	 * @return the element at position <tt>index</tt> or throw an
	 *         <tt>IndexOutOfBoundsException</tt>
	 */
	public T get(int index) {
		return list.get(index);
	}

	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(getClass().getName());
		sb.append(" [");

		int i = 0;
		for (T item : this) {
			if (i > 0) {
				sb.append(", ");
			}

			sb.append(item);
			i++;
		}

		sb.append("]");

		return sb.toString();
	}

}
