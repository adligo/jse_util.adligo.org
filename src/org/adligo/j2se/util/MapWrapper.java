package org.adligo.j2se.util;

import java.util.Collection;
import java.util.Map;

import org.adligo.i.util.client.I_Iterator;
import org.adligo.i.util.client.I_Map;
import org.adligo.i.util.client.IteratorFactory;

public class MapWrapper extends ImmutableMapWrapper implements I_Map {
	
	
	public MapWrapper(Map p) {
		super(p);
	}
	

	public void putAll(Map m) {
		me.putAll(m);
	}

	public void clear() {
		me.clear();
	}


	public Object put(Object key, Object value) {
		return me.put(key, value);
	}


	public Object remove(Object key) {
		return me.remove(key);
	}



	public Object getWrapped() {
		return me;
	}
	
}
