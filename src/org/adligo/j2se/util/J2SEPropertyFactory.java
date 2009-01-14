package org.adligo.j2se.util;

import java.io.IOException;
import java.io.InputStream;

import org.adligo.i.util.client.Event;
import org.adligo.i.util.client.I_Factory;
import org.adligo.i.util.client.I_Listener;
import org.adligo.i.util.client.I_Map;
import org.adligo.i.util.client.ListenerValueObject;
import org.adligo.i.util.client.MapFactory;
import org.adligo.i.util.client.PropertyFactory;
import org.adligo.i.util.client.StringUtils;

public class J2SEPropertyFactory extends PropertyFactory implements I_Factory {

	/**
	 * get a file from the relative url
	 * this is done in a single threaded synchronus way
	 * with a callback
	 * 
	 */
	public Object createNew(Object p) {
		ListenerValueObject list = (ListenerValueObject) p;
		String propClasspathName = (String) list.getValue();
		I_Listener callback = list.getListener();
		
		try {
			InputStream in = J2SEPropertyFactory.class.getResourceAsStream(propClasspathName);
			
			/**
			 * this will only read askii and not 
			 * extended utf8 (chineese, sanskrit exc)
			 */
			StringBuffer sb = new StringBuffer();
			byte [] b = new byte[1];
			if (in != null) {
				while ( (in.read(b)) != -1) {
					sb.append((char) b[0]);
				}
			}
			I_Map map = MapFactory.create();
			StringUtils.parse(sb.toString(), map);
			Event e = new Event();
			e.setValue(map);
			callback.onEvent(e);
			
		} catch (IOException x) {
			x.printStackTrace();
		}
		
		return callback;
	}
	
	protected static void init() throws Exception {
		init(new J2SEPropertyFactory());
	}
}

