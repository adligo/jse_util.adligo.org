package org.adligo.jse.util;

import org.adligo.i.util.client.AppenderFactory;
import org.adligo.i.util.client.I_Factory;

public class JSEAppenderFactory extends AppenderFactory implements I_Factory {
	public Object createNew(Object p) {
		return new JSEAppender();
	}

	protected static void init() throws Exception {
		init(new JSEAppenderFactory());
	}
}
