package org.adligo.jse.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
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
		String fileName = (String) list.getValue();
		I_Listener callback = list.getListener();
		String fileSystemFileName = null;
		I_Map fileContent = null;
		
		//try the filesystem first
		try {
			BufferedReader br = null;
			File file = new File(fileName);
			if (file.isFile()) {
				br = new BufferedReader(new InputStreamReader(
	                    new FileInputStream(file),"UTF8"));
			} else {
				//try from the classpath
				Class<?> c = this.getClass();
		        URL r = c.getResource(fileName);
		        if (r == null) {
		        	setUpError(fileName, callback, fileSystemFileName, fileContent, 
		        			new FileNotFoundException("no file found in classpath with " +
		        					fileName));
		        	return callback;
		        }
		        fileSystemFileName = r.getFile();
		        InputStream in = r.openStream();
				
		         br = new BufferedReader(new InputStreamReader(
	                    in,"UTF8"));
			}
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				sb.append('\n');
				line = br.readLine();
			}
			I_Map map = MapFactory.create();
			StringUtils.parse(sb.toString(), map);
			fileContent = map;
			
			Event e = new Event();
			e.setValue(map);
			callback.onEvent(e);
		} catch (UnsupportedEncodingException x) {
			setUpError(fileName, callback, fileSystemFileName, fileContent, x);
		} catch (FileNotFoundException x) {
			setUpError(fileName, callback, fileSystemFileName, fileContent, x);
		} catch (IOException x) {
			setUpError(fileName, callback, fileSystemFileName, fileContent, x);
		}
		return callback;
	}

	private void setUpError(String fileName, I_Listener callback,
			String fileSystemFileName, I_Map fileContent,
			Exception x) {
		PropertyFileReadException ex = new PropertyFileReadException(
				"Error reading property file '" + fileName + "' " +
				" file system name '" + fileSystemFileName + "' file content; \n" + 
				fileContent);
		ex.setFileName(fileName);
		ex.setAttemptedSystemFileName(fileSystemFileName);
		ex.initCause(x);
		
		Event e = new Event();
		e.setValue(MapFactory.create());
		e.setException(ex);
		callback.onEvent(e);
	}
	
	protected static void init() throws Exception {
		init(new JSEPropertyFactory());
	}
}

