package org.adligo.jse.util;

import org.adligo.i.util.client.DateTimeParserFactory;
import org.adligo.i.util.client.I_Factory;

public class JSEDateTimeParserFactory extends DateTimeParserFactory implements I_Factory {

	public Object createNew(Object p) {
		return new JSEDateTimeParser();
	}
	
	protected static void init() throws Exception {
		init(new JSEDateTimeParserFactory());
	}
}
