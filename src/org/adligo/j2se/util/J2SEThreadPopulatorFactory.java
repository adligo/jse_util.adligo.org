package org.adligo.j2se.util;

import org.adligo.i.util.client.I_ThreadContainer;
import org.adligo.i.util.client.I_ThreadPopulator;
import org.adligo.i.util.client.ThreadPopulatorFactory;

public class J2SEThreadPopulatorFactory extends ThreadPopulatorFactory implements I_ThreadPopulator {
	private static final J2SEThreadPopulatorFactory INSTANCE = new J2SEThreadPopulatorFactory();
	
	
	private J2SEThreadPopulatorFactory() {}
	
	@Override
	public void populateThread(I_ThreadContainer threadHolder) {
		threadHolder.setThread(Thread.currentThread().getName());
	}

	
	protected static void init() throws Exception {
		ThreadPopulatorFactory.init(INSTANCE);
	}
	
}
