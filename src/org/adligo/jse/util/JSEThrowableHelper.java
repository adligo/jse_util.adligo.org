package org.adligo.jse.util;

import org.adligo.i.util.client.I_Appender;
import org.adligo.i.util.client.I_ThrowableHelper;

public class JSEThrowableHelper implements I_ThrowableHelper {

	protected JSEThrowableHelper() {}
	
	@Override
	public void fillInStackTrace(Throwable p) {
		p.fillInStackTrace();
	}

	@Override
	public void appendStackTracesString(String preText, Throwable throwable,
			String lineFeed, I_Appender buf) {
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
            Throwable cause = throwable.getCause();
            if (cause != null) {
            	appendStackTracesString(preText + preText, cause, lineFeed, buf);
            }
        }
	}
	


}
