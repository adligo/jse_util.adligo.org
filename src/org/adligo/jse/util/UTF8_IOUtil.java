package org.adligo.jse.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.CharBuffer;

public class UTF8_IOUtil {
	public static String getXMLContent(String javaPath) throws IOException {
	 	Class<?> c = UTF8_IOUtil.class.getClass();
        URL r = c.getResource(javaPath);
        if (r == null) {
        	 IllegalArgumentException toThrow = new IllegalArgumentException(
       			  "THERE_WAS_A_PROBLEM_PARSING_OR_COULD_NOT_FIND_RESOURCE" + javaPath);
        	 throw toThrow;
        }
       
        InputStream is = r.openStream();
        return getXMLContent(is);
	}

	public static String getXMLContent(InputStream is)
			throws IOException, UnsupportedEncodingException {
		InputStreamReader isr = new InputStreamReader(is);
       
        CharBuffer cb = CharBuffer.allocate(10000);
        isr.read(cb);
        String result = new String(cb.array()).trim();
        result = new String(result.getBytes(),"UTF-8");
        isr.close();
        is.close();
        is.close();
        return result;
	}
	
	public static void writeXMLContent(String sFileName, String content) throws IOException {
		File file = new File(sFileName);
		file.createNewFile();
		FileOutputStream fos = new FileOutputStream(file);
		byte [] contentBytes = content.getBytes("UTF-8");
		fos.write(contentBytes);
		fos.close();
	}
}
