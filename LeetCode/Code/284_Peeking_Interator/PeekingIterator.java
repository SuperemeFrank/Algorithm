// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iter;
    boolean hNext;
    int cur;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    iter = iterator;
        if (iter.hasNext()) {
            cur = iter.next();
            hNext = true;
        }else {
            hNext = false;
        }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return cur;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int res = cur;
        if (iter.hasNext()) {
            cur = iter.next();
            hNext = true;;
        }else {
            hNext = false;
        }
        return res;
	}

	@Override
	public boolean hasNext() {
	    return hNext;
	}
}

/*
    1 2 3
    PeekingIterator is always one step slower than the inner Iterator
    hNext maintain the flag of whether next exists, it should be  update each time excute next()
*/
