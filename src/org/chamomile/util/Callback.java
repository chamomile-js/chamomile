package org.chamomile.util;

/**
 * The {@code Callback} interface is designed to allow for a common, reusable
 * interface to exist for defining APIs that requires a call back in certain
 * situations.
 * 
 * @param <P>
 *            The type of the argument provided to the {@link #call} method.
 * @param <R>
 *            The type of the return type of the {@link #call} method.
 */
public interface Callback<P, R> {
	R call(P value);
}