package org.adligo.j2se.util;

import java.util.Collection;
import java.util.Map;

import org.adligo.i.util.client.I_Iterator;
import org.adligo.i.util.client.I_Map;
import org.adligo.i.util.client.IteratorFactory;

public class MapWrapper implements I_Map {
	private Map  me = null;
	
	public MapWrapper(Map p) {
		me = p;
	}
	
	public I_Iterator getIterator() {
		Collection keys = me.keySet();
		return IteratorFactory.create(keys);
	}

	public void putAll(Map m) {
		me.putAll(m);
	}

	public void clear() {
		me.clear();
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

	public Object put(Object key, Object value) {
		return me.put(key, value);
	}


	public Object remove(Object key) {
		return me.remove(key);
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

	public Object getWrapped() {
		return me;
	}
	
}
