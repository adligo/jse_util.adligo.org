package org.adligo.jse.util;

import java.util.ArrayList;
import java.util.Collection;

import org.adligo.i.util.shared.CollectionFactory;
import org.adligo.i.util.shared.I_Factory;

public class JSECollectionFactory extends CollectionFactory implements I_Factory {
	
	public Object createNew(Object p) {
		if (p == null) {
			return new CollectionWrapper(new ArrayList<Object>());
		}
		return new CollectionWrapper((Collection<?>) p);
	}

	protected static void init() throws Exception {
		init(new JSECollectionFactory());
	}
}
