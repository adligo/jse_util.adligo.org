package org.adligo.j2se.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.adligo.i.util.client.ClassUtils;
import org.adligo.i.util.client.I_Map;

@SuppressWarnings("unchecked")
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


	@Override
	public String toString() {
		if (me == null) {
			return MapWrapper.class.getName() + " []";
		}
		return ClassUtils.getClassShortName(MapWrapper.class) +  me.toString();
	}
	
	

}
