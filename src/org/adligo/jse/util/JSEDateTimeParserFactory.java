package org.adligo.jse.util;

import org.adligo.i.util.shared.DateTimeParserFactory;
import org.adligo.i.util.shared.I_Factory;

public class JSEDateTimeParserFactory extends DateTimeParserFactory implements I_Factory {

	public Object createNew(Object p) {
		return new JSEDateTimeParser();
	}
	
	protected static void init() throws Exception {
		init(new JSEDateTimeParserFactory());
	}
}
