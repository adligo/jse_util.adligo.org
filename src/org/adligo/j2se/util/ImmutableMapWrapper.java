package org.adligo.j2se.util;

import java.util.Collection;
import java.util.Map;

import org.adligo.i.util.client.I_ImmutableMap;
import org.adligo.i.util.client.I_Iterator;
import org.adligo.i.util.client.IteratorFactory;

@SuppressWarnings("unchecked")
public class ImmutableMapWrapper implements I_ImmutableMap {
	protected Map  me = null;
	
	public ImmutableMapWrapper(Map p) {
		me = p;
	}
	
	
	public I_Iterator getIterator() {
		Collection keys = me.keySet();
		return IteratorFactory.create(keys);
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
	/**
	 * will cast to Set
	 */
	public I_Iterator keys() {
		return this.getIterator();
	}
	
	public boolean equals(Object o) {
		if (o instanceof MapWrapper) {
			if (me.equals( ((MapWrapper) o).me )) {
				return true;
			}
		}
		return false;
	}
	
}
