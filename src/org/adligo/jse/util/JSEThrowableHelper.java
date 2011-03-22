package org.adligo.jse.util;

import java.io.PrintWriter;

import org.adligo.i.log.client.models.StringWriter;
import org.adligo.i.util.client.I_ThrowableHelper;
import org.adligo.i.util.client.InstanceForName;
import org.adligo.i.util.client.ThrowableHelperFactory;

public class JSEThrowableHelper extends ThrowableHelperFactory implements I_ThrowableHelper {

	private JSEThrowableHelper() {}
	
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

	public static void init() throws Exception {
		ThrowableHelperFactory.init(new JSEThrowableHelper());
	}
}
