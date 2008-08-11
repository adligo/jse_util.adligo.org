package org.adligo.j2se.util;

import java.util.Collection;

import org.adligo.i.util.client.I_Factory;
import org.adligo.i.util.client.IteratorFactory;

public class J2SEIteratorFactory extends IteratorFactory implements I_Factory {
	
	public Object createNew(Object p) {
		return new IteratorWrapper(((Collection) p).iterator());
	}

	protected static void init() throws Exception {
		IteratorFactory.init(new J2SEIteratorFactory());
	}
}
