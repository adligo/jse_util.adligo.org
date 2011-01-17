package org.adligo.jse.util;

import java.util.Iterator;
import org.adligo.i.util.client.I_Iterator;


public class IteratorWrapper implements I_Iterator {
	public Iterator me = null;
	
	public IteratorWrapper(Iterator p) {
		me = p;
	}
	
	public boolean hasNext() {
		return me.hasNext();
	}
	public Object next() {
		return me.next();
	}
	
	public Object getWrapped() {
		return me;
	}
}