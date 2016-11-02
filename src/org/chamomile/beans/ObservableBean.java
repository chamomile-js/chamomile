package org.chamomile.beans;

import java.util.Objects;

import org.chamomile.collections.AbstractMap;
import org.chamomile.util.Callback;
import org.chamomile.util.ListenerList;

import javascript.JSObject;

public class ObservableBean extends AbstractMap<String, Object> {

	private class BeanListenerList extends ListenerList<BeanListener>
			implements BeanListener {
		@Override
		public void propertyChanged(ObservableBean bean, String property, Object previousValue) {
			for (BeanListener listener : this) {
				listener.propertyChanged(bean, property, previousValue);
			}
		}
	}

	// ---

	private transient BeanListenerList beanListeners = null;

	private final JSObject data;

	public ObservableBean() {
		data = new JSObject();
	}

	@Override
	public Object get(String property) {
		return data.get(property);
	}

	protected Object get(String property, Object valueIfNull) {
		Object value = get(property);
		return value != null ? value : valueIfNull;
	}

	@Override
	public Object put(String property, Object value) {
		if (property == null) {
			throw new IllegalArgumentException("property cannot be null.");
		}

		if (property.length() == 0) {
			throw new IllegalArgumentException("property is empty.");
		}

		if (property.charAt(0) == '_') {
			throw new UnsupportedOperationException("propery is read only");
		}

		return put(property, value, null);
	}

	protected <T> Object put(String property, T value, Callback<T, Void> callback) {
		@SuppressWarnings("unchecked")
		T previousValue = (T) get(property);

		if (!Objects.equals(value, previousValue)) {
			super.put(property, value);
			if (callback != null) {
				callback.call(previousValue);
			}
			data.put(property, value);
			if (beanListeners != null) {
				beanListeners.propertyChanged(this, property, previousValue);
			}
		}

		return previousValue;
	}

	@Override
	protected Object putImpl(String key, Object value) {
		Object previousValue = data.get(key);
		data.put(key, value);
		return previousValue;
	}

	@Override
	public final Object remove(String key) {
		throw new UnsupportedOperationException();
	}

	@Override
	protected Object removeImpl(String key) {
		throw new UnsupportedOperationException();
	}

	@Override
	public final void clear() {
		throw new UnsupportedOperationException();
	}

	@Override
	protected void clearImpl() {
		throw new UnsupportedOperationException();
	}

	@Override
	public final int getCount() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsKey(String key) {
		return data.containsKey(key);
	}

	public ListenerList<BeanListener> getBeanListeners() {
		if (beanListeners == null) {
			beanListeners = new BeanListenerList();
		}
		return beanListeners;
	}
}
