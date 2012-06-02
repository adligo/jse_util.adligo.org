package org.adligo.jse.util;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.adligo.i.util.client.I_DateTimeParser;

import com.sun.xml.internal.txw2.IllegalAnnotationException;

public class JSEDateTimeParser implements I_DateTimeParser {

	@Override
	public long parse(String format, String value)
			throws IllegalArgumentException {
		
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			Date date = sdf.parse(value);
			return date.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
			throw new IllegalAnnotationException(e);
		}
	}

}
