package org.adligo.jse.util;

import org.adligo.i.util.client.I_ThrowableHelper;

public class JSEThrowableHelper implements I_ThrowableHelper {

	protected JSEThrowableHelper() {}
	
	@Override
	public void fillInStackTrace(Throwable p) {
		p.fillInStackTrace();
	}

	@Override
	public String getStackTraceAsString(Throwable throwable) {
		StringBuilder buf = new StringBuilder();
		
        if(throwable != null) {
        	StackTraceElement [] trace = throwable.getStackTrace();
        	buf.append(" <");
            buf.append(throwable.toString());
            buf.append(">");

            buf.append("\n");
           
            
            for (int j = 0; j < trace.length; j++) {
            	buf.append("\t at ");
            	buf.append(trace[j].toString());
            	buf.append("\n");
			}
        }
        return buf.toString();
	}
	


}
