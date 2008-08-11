package org.adligo.j2se.util;

import org.adligo.i.util.client.I_Map;
import org.adligo.i.util.client.Platform;


public class J2SEPlatform extends Platform {
	private static boolean isInit = false;

	/**
	 * this must be called by the main EntryPoint first
	 * before anyother code can be used!
	 */
	public static synchronized final void init() throws Exception {
		if (!isInit) {
			J2SEIteratorFactory.init();
			J2SECollectionFactory.init();
			J2SEMapFactory.init();
			J2SEPropertyFactory.init();
			isInit = true;
		}
	}
	
	protected static boolean isLogEnabled() {
		return false;
	}
	
	protected static void log(String p){
		System.out.println(p);
	}
	
}
