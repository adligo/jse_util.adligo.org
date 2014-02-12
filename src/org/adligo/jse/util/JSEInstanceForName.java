package org.adligo.jse.util;

import org.adligo.i.util.shared.I_Factory;
import org.adligo.i.util.shared.InstanceForName;

public class JSEInstanceForName extends InstanceForName implements I_Factory {

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
		InstanceForName.init(new JSEInstanceForName());
	}

}
