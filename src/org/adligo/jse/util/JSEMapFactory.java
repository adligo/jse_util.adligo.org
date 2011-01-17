package org.adligo.jse.util;

import java.util.HashMap;
import java.util.Map;

import org.adligo.i.util.client.I_Factory;
import org.adligo.i.util.client.MapFactory;


public class JSEMapFactory extends MapFactory implements I_Factory {

	
	public Object createNew(Object p) {
		if (p == null) {
			return new MapWrapper(new HashMap<Object,Object>());
		}
		return new MapWrapper((Map<?,?>) p);
	}

	protected static void init() throws Exception {
		init(new JSEMapFactory(), new JSEImmutableMapFactory());
	}
}
