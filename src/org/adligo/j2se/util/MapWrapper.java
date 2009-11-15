package org.adligo.j2se.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

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
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getName());
		sb.append(" [[[[items[[[");
		toString(me, sb);
		sb.append("]]]end_map_items]]]]");
		return sb.toString();
	}
	
	public static void  toString(Map<?,?> p, StringBuilder sb) {
		Set<?>  set = p.entrySet();
		Iterator<?> it = set.iterator();
		while (it.hasNext()) {
			Entry<?,?> e = (Entry<?,?>) it.next();
			sb.append(e.getKey());
			sb.append(",");
			sb.append(e.getValue());
		}
	}
	

}
