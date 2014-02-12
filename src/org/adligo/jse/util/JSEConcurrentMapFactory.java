package org.adligo.jse.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.adligo.i.util.shared.I_Factory;
import org.adligo.i.util.shared.I_Map;

public class JSEConcurrentMapFactory implements I_Factory {

	public Object createNew(Object p) {
		if (p == null) {
			return new MapWrapper(new ConcurrentHashMap<Object,Object>());
		}
		Map<Object,Object> toWrap = new ConcurrentHashMap<Object,Object>();
		toWrap.putAll((Map<?,?>) ((I_Map) p).getWrapped());
		return new MapWrapper(toWrap);
	}
}
