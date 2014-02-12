package org.adligo.jse.util;

import org.adligo.i.util.shared.I_ThreadContainer;
import org.adligo.i.util.shared.I_ThreadPopulator;
import org.adligo.i.util.shared.ThreadPopulatorFactory;

public class JSEThreadPopulatorFactory extends ThreadPopulatorFactory implements I_ThreadPopulator {
	private static final JSEThreadPopulatorFactory INSTANCE = new JSEThreadPopulatorFactory();
	
	
	private JSEThreadPopulatorFactory() {}
	
	@Override
	public void populateThread(I_ThreadContainer threadHolder) {
		threadHolder.setThread(Thread.currentThread().getName());
	}

	
	protected static void init() throws Exception {
		ThreadPopulatorFactory.init(INSTANCE);
	}
	
}
