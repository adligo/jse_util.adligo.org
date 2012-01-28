package org.adligo.jse.util;

import org.adligo.i.util.client.I_Appender;

public class JSESAppender implements I_Appender {
	private StringBuilder sb;

	JSESAppender() {
		sb = new StringBuilder();
	}

	@Override
	public void append(String p) {
		sb.append(p);
	}
	
	@Override
	public String toString() {
		return sb.toString();
	}

	public void append(boolean b) {
		sb.append(b);
	}

	public void append(char c) {
		sb.append(c);
	}

	public void append(double d) {
		sb.append(d);
	}

	public void append(float f) {
		sb.append(f);
	}

	public void append(int i) {
		sb.append(i);
	}

	public void append(long lng) {
		sb.append(lng);
	}

	public void append(Object obj) {
		sb.append(obj);
	}

	@Override
	public void append(short p) {
		sb.append(p);
	}

	@Override
	public void append(byte p) {
		sb.append(p);
	}
}
