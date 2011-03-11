package org.adligo.jse.util;

import java.io.InputStream;
import java.net.URL;

import org.adligo.i.util.client.Event;
import org.adligo.i.util.client.I_Factory;
import org.adligo.i.util.client.I_Listener;
import org.adligo.i.util.client.I_Map;
import org.adligo.i.util.client.ListenerValueObject;
import org.adligo.i.util.client.MapFactory;
import org.adligo.i.util.client.PropertyFactory;
import org.adligo.i.util.client.PropertyFileReadException;
import org.adligo.i.util.client.StringUtils;

public class JSEPropertyFactory extends PropertyFactory implements I_Factory {
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
		String fileSystemFileName = null;
		I_Map fileContent = null;
		
		try {
			Class<?> c = this.getClass();
	        URL r = c.getResource(propClasspathName);
	        fileSystemFileName = r.getFile();
	        InputStream in = r.openStream();
			
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
			fileContent = map;
			
			Event e = new Event();
			e.setValue(map);
			callback.onEvent(e);
			
		} catch (Exception x) {
			PropertyFileReadException ex = new PropertyFileReadException(
					"Error reading property file '" + propClasspathName + "' " +
					" file system name '" + fileSystemFileName + "' file content; \n" + 
					fileContent);
			ex.setFileName(propClasspathName);
			ex.setAttemptedSystemFileName(fileSystemFileName);
			ex.initCause(x);
			
			Event e = new Event();
			e.setValue(MapFactory.create());
			e.setException(ex);
			callback.onEvent(e);
		}
		
		return callback;
	}
	
	protected static void init() throws Exception {
		init(new JSEPropertyFactory());
	}
}

