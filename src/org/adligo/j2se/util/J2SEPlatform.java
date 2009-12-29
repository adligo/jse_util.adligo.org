package org.adligo.j2se.util;

import org.adligo.i.util.client.Platform;


public class J2SEPlatform extends Platform {
	
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
		if (!J2SEInstanceForName.isInit()) {
			J2SEInstanceForName.init();
		}
		if (!J2SECollectionFactory.isInit()) {
			J2SECollectionFactory.init();
		}
		if (!J2SEMapFactory.isInit()) {
			J2SEMapFactory.init();
		}
		if (!J2SEIteratorFactory.isInit()) {
			J2SEIteratorFactory.init();
		}
		if (!J2SEPropertyFactory.isInit()) {
			J2SEPropertyFactory.init();
		}
		if (!J2SEThreadPopulatorFactory.isInit()) {
			J2SEThreadPopulatorFactory.init();
		}
		if (!J2SETextFormatter.isInit()) {
			J2SETextFormatter.init();
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
