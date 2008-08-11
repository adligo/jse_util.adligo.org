package org.adligo.j2se.util;

import java.util.Collection;

import org.adligo.i.util.client.I_Collection;
import org.adligo.i.util.client.I_Iterator;

public class CollectionWrapper implements I_Collection {
	private Collection col = null;
	
	public CollectionWrapper(Collection c) {
		col = c;
	}
	
	public boolean add(Object o) {
		return col.add(o);
	}

	public void clear() {
		col.clear();
	}

	public I_Iterator getIterator() {
		return new IteratorWrapper(col.iterator());
	}

	public boolean remove(Object o) {
		return col.remove(o);
	}
	public Object getWrapped() {
		return col;
	}
	public int size() {
		return col.size();
	}
}
