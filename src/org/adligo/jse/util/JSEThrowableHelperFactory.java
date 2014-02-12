package org.adligo.jse.util;

import org.adligo.i.util.shared.ThrowableHelperFactory;

public class JSEThrowableHelperFactory extends ThrowableHelperFactory {

	public static void init() throws Exception {
		ThrowableHelperFactory.init(new JSEThrowableHelper());
	}
}
