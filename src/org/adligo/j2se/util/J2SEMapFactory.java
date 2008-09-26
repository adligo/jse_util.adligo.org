package org.adligo.j2se.util;

import java.util.HashMap;
import java.util.Map;

import org.adligo.i.util.client.I_Factory;
import org.adligo.i.util.client.MapFactory;


public class J2SEMapFactory extends MapFactory implements I_Factory {

	
	public Object createNew(Object p) {
		if (p == null) {
			return new MapWrapper(new HashMap());
		}
		return new MapWrapper((Map) p);
	}

	protected static void init() throws Exception {
		init(new J2SEMapFactory(), new J2SEImmutableMapFactory());
	}
}
