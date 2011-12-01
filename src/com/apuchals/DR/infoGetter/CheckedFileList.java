package com.apuchals.DR.infoGetter;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import com.apuchals.DR.toRemove.NotImplementedException;

public class CheckedFileList {

	protected int size;

	private ArrayList<CheckedFile> innerList;

	public CheckedFileList() {
		innerList = new ArrayList<CheckedFile>();
	}

	public Iterator<CheckedFile> iterator() {
		return iterator(null);
	}

	public Iterator<CheckedFile> iterator(String[] extensions) {
		if (extensions == null)
			return innerList.iterator();
		Iterator<CheckedFile> i = new HiddenIterator(extensions);
		return i;
		// TODO 01.12.2011 apuchals >
	}

	public boolean add(CheckedFile cf) {
		boolean add = innerList.add(cf);
		size = innerList.size();
		return add;
	}

	private CheckedFile get(int i) {
		return innerList.get(i);
	}

	private class HiddenIterator implements Iterator<CheckedFile> {

		int last;

		int currentListSize;

		private String[] extensions;

		public HiddenIterator(String[] extensions) {
			this.extensions = extensions;
			last = -1;
			currentListSize = size;
		}

		@Override
		public boolean hasNext() {
			return nextIndex() != -1;
		}

		private int nextIndex() {
			if (currentListSize == 0) {
				return -1;
			}
			return findFirstMatching(last);
		}

		private int findFirstMatching(int lastFound) {
			CheckedFile toCheck = null;
			try {
				toCheck = get(++lastFound);
			} catch (IndexOutOfBoundsException e) {
				return -1;
			}
			if (matches(toCheck, extensions)) {
				return lastFound;
			}
			return findFirstMatching(lastFound);
		}

		private boolean matches(IFileExtension toCheck, String[] extensions2) {
			for (String s : extensions2) {
				if (toCheck.getFileExtension().endsWith(s)) {
					return true;
				}
			}
			return false;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#next()
		 * 
		 * almost identical operations as the original, but the filetypes are
		 * checked too here...
		 */
		@Override
		public CheckedFile next() {
			checkForComodification();
			try {
				last = nextIndex();
				// check Extension and go on...
				CheckedFile next = get(last);
				return next;
			} catch (IndexOutOfBoundsException e) {
				checkForComodification();
				throw new NoSuchElementException();
			}
		}

		private void checkForComodification() {
			if (size != currentListSize)
				throw new ConcurrentModificationException();
		}

		@Override
		public void remove() {
			// TODO 01.12.2011 apuchals > do not allow this!
			throw new NotImplementedException();
		}

	}

}
