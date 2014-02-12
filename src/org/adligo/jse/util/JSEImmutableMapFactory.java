package org.adligo.jse.util;

import java.util.HashMap;
import java.util.Map;

import org.adligo.i.util.shared.I_Factory;
import org.adligo.i.util.shared.I_Map;

public class JSEImmutableMapFactory implements I_Factory {

	public Object createNew(Object p) {
		if (p == null) {
			return new ImmutableMapWrapper(new HashMap<Object,Object>());
		}
		return new ImmutableMapWrapper((Map<?,?>) ((I_Map) p).getWrapped());
	}
}
