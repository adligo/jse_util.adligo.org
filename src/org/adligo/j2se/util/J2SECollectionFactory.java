package org.adligo.j2se.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.adligo.i.util.client.CollectionFactory;
import org.adligo.i.util.client.I_Factory;

public class J2SECollectionFactory extends CollectionFactory implements I_Factory {
	
	public Object createNew(Object p) {
		if (p == null) {
			return new CollectionWrapper(new ArrayList());
		}
		return new CollectionWrapper((Collection) p);
	}

	protected static void init() throws Exception {
		init(new J2SECollectionFactory());
	}
}
