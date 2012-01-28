package org.adligo.jse.util;

import org.adligo.i.util.client.I_StringAppender;
import org.adligo.i.util.client.I_ThrowableHelper;

public class JSEThrowableHelper implements I_ThrowableHelper {

	protected JSEThrowableHelper() {}
	
	@Override
	public void fillInStackTrace(Throwable p) {
		p.fillInStackTrace();
	}

	@Override
	public String getStackTraceAsString(Throwable throwable) {
		return getStackTraceAsString("\t", throwable, "\n", 
					new JSEStringBuilderAppender());
	}

	@Override
	public String getStackTraceAsString(String preText, Throwable throwable,
			String lineFeed, I_StringAppender buf) {
		if(throwable != null) {
        	StackTraceElement [] trace = throwable.getStackTrace();
        	buf.append(preText);
        	buf.append(" <");
            buf.append(throwable.toString());
            buf.append(">");

            buf.append(lineFeed);
           
            
            for (int j = 0; j < trace.length; j++) {
            	//do twice as many indents for the stack trace
            	buf.append(preText);
            	buf.append(preText);
            	buf.append(" at ");
            	buf.append(trace[j].toString());
            	buf.append(lineFeed);
			}
        }
        return buf.toString();
	}
	


}
