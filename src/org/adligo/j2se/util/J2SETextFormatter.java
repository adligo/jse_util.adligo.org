package org.adligo.j2se.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.adligo.i.util.client.TextFormatter;

public class J2SETextFormatter extends TextFormatter {
	protected static void init() throws Exception {
		TextFormatter.setDelegate(new J2SETextFormatter());
	}

	
	public String format(String format, double value) {
		DecimalFormat fmt = new  DecimalFormat(format);
		return fmt.format(value);
	}

	
	public String format(String format, float value) {
		DecimalFormat fmt = new  DecimalFormat(format);
		return fmt.format(value);
	}

	
	public String format(String format, int value) {
		DecimalFormat fmt = new  DecimalFormat(format);
		return fmt.format(value);
	}

	
	public String format(String format, long value) {
		DecimalFormat fmt = new  DecimalFormat(format);
		return fmt.format(value);
	}

	
	public String format(String format, short value) {
		DecimalFormat fmt = new  DecimalFormat(format);
		return fmt.format(value);
	}

	public String formatDate(String format, long value) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date(value));
	}
}
