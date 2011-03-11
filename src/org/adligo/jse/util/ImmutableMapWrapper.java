package org.adligo.jse.util;

import java.util.Collection;
import java.util.Map;

import org.adligo.i.util.client.I_ImmutableMap;
import org.adligo.i.util.client.I_Iterator;
import org.adligo.i.util.client.IteratorFactory;

public class ImmutableMapWrapper implements I_ImmutableMap {
	@SuppressWarnings("rawtypes")
	protected Map  me = null;
	
	public ImmutableMapWrapper(@SuppressWarnings("rawtypes") Map p) {
		if (p == null) {
			throw new NullPointerException("" + this.getClass() + 
					" can't accept a null constructor argument.");
		}
		me = p;
	}
	
	
	public I_Iterator getKeysIterator() {
		@SuppressWarnings("rawtypes")
		Collection keys = me.keySet();
		return IteratorFactory.create(keys);
	}
	
	public I_Iterator getValuesIterator() {
		@SuppressWarnings("rawtypes")
		Collection values = me.values();
		return IteratorFactory.create(values);
	}
	
	public int size() {
		return me.size();
	}

	/**
	 * will cast to Collection
	 */
	public Object values() {
		return me.values();
	}
	

	public boolean containsKey(Object key) {
		return me.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return me.containsValue(value);
	}

	public Object get(Object key) {
		return me.get(key);
	}

	
	public boolean isEmpty() {
		return me.isEmpty();
	}
	
	public boolean equals(Object o) {
		if (o instanceof MapWrapper) {
			if (me.equals( ((MapWrapper) o).me )) {
				return true;
			}
		}
		return false;
	}


	@Override
	public int hashCode() {
		return me.hashCode();
	}


	@Override
	public String toString() {
		return me.toString();
	}
	
}
