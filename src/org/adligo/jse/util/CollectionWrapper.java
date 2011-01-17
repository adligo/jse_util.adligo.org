package org.adligo.jse.util;

import java.util.Collection;

import org.adligo.i.util.client.I_Collection;
import org.adligo.i.util.client.I_Iterator;

@SuppressWarnings("unchecked")
public class CollectionWrapper implements I_Collection {
	private Collection col = null;
	
	public CollectionWrapper(Collection c) {
		if (c == null) {
			throw new NullPointerException("" + this.getClass() + " can't accept a null constructor argument.");
		}
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

	@Override
	public boolean equals(Object obj) {
		return col.equals(obj);
	}

	@Override
	public int hashCode() {
		return col.hashCode();
	}

	@Override
	public String toString() {
		return col.toString();
	}

	@Override
	public boolean contains(Object other) {
		return col.contains(other);
	}
	
	
}
