package org.adligo.j2se.util;

import org.adligo.i.util.client.I_Factory;
import org.adligo.i.util.client.InstanceForName;

public class J2SEInstanceForName extends InstanceForName implements I_Factory {

	@Override
	public Object createNew(Object p) {
		try {
			Class<?> c = Class.forName((String) p);
			return c.newInstance();
		} catch (Exception x) {
			x.printStackTrace();
		}
		return null;
	}
	
	public static void init() throws Exception {
		InstanceForName.init(new J2SEInstanceForName());
	}

}
