package org.adligo.jse.util;

import org.adligo.i.log.client.Log;
import org.adligo.i.log.client.LogFactory;
import org.adligo.i.log.client.LogPlatform;

public class JSECommonInit {
	private static final Log log = LogFactory.getLog(JSECommonInit.class);
	
	/**
	 * note this is what Log4j and Commons logging
	 * do in the Logger/LogFactory classes, which is nice
	 * however it needs to be done here to use
	 * i_log since i_log doesn't have that stuff 
	 * coded into it so that it can run in GWT (Javascript)
	 * 
	 * Also note LogProviders have been moved to the Controller servlet
	 * you need to pass in the class name of your LogFactory
	 * 
	 */
	static {
		try {
			JSEPlatform.init();
			if (!LogPlatform.isInit()) {
				LogPlatform.init();
			}
		} catch (Exception x) {
			x.printStackTrace();
		}
	}
	
	private JSECommonInit() {}
	
	/**
	 * call this method which does nothing just to
	 * make sure the class gets loaded and that it's static init method
	 * is called
	 * 
	 * @param p
	 */
	public static final void callLogDebug(String p) {
		if (log.isDebugEnabled()) {
			log.debug(p);
		}
	}
}
