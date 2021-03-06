package org.adligo.jse.util;

import org.adligo.i.util.shared.Platform;


public class JSEPlatform extends Platform {
	
	private static boolean log = false;
	/**
	 * this must be called by the main EntryPoint first
	 * before anyother code can be used!
	 */
	public static synchronized final void init() throws Exception {
		init(false);
	}
	public static synchronized final void init(boolean p) throws Exception {
		setLogEnabled(p);
		if (!JSEAppenderFactory.isInit()) {
			JSEAppenderFactory.init();
		}
		if (!JSEThrowableHelperFactory.isInit()) {
			JSEThrowableHelperFactory.init();
		}
		if (!JSEInstanceForName.isInit()) {
			JSEInstanceForName.init();
		}
		if (!JSECollectionFactory.isInit()) {
			JSECollectionFactory.init();
		}
		if (!JSEMapFactory.isInit()) {
			JSEMapFactory.init();
		}
		if (!JSEIteratorFactory.isInit()) {
			JSEIteratorFactory.init();
		}
		if (!JSEPropertyFactory.isInit()) {
			JSEPropertyFactory.init();
		}
		if (!JSEThreadPopulatorFactory.isInit()) {
			JSEThreadPopulatorFactory.init();
		}
		if (!JSETextFormatter.isInit()) {
			JSETextFormatter.init();
		}
		if (!JSEDateTimeParserFactory.isInit()) {
			JSEDateTimeParserFactory.init();
		}
	}
	
	public static boolean isLogEnabled() {
		return log;
	}
	
	public static void setLogEnabled(boolean p) {
		log = p;
	}
	
	protected static void log(String p){
		System.out.println(p);
	}
	
}
