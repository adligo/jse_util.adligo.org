package org.adligo.jse.util;

import org.adligo.i.util.client.I_StringAppender;

public class JSEStringBuilderAppender implements I_StringAppender {
	private StringBuilder sb;

	public JSEStringBuilderAppender() {
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
}
