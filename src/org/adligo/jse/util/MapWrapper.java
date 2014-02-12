package org.adligo.jse.util;

import java.util.Map;

import org.adligo.i.util.shared.I_Map;

@SuppressWarnings("unchecked")
public class MapWrapper extends ImmutableMapWrapper implements I_Map {
	
	public MapWrapper(@SuppressWarnings("rawtypes") Map p) {
		super(p);
	}
	
	public void putAll(@SuppressWarnings("rawtypes") Map m) {
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
