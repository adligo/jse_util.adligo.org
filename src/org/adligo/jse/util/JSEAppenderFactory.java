package org.adligo.jse.util;

import org.adligo.i.util.shared.AppenderFactory;
import org.adligo.i.util.shared.I_AppenderFactory;

public class JSEAppenderFactory extends AppenderFactory implements I_AppenderFactory {
	public String getLineSeperator() {
		return System.getProperty("line.seperator");
	}
	
	public Object createNew(Object p) {
		return new JSEAppender();
	}

	protected static void init() throws Exception {
		init(new JSEAppenderFactory());
	}
}
