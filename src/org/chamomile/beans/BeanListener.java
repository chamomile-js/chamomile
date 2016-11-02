package org.chamomile.beans;

public interface BeanListener {
	void propertyChanged(ObservableBean bean, String property, Object previousValue);
}
