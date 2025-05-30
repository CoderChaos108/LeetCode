// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    ArrayList<Integer> list;
    int i;
	public PeekingIterator(Iterator<Integer> iterator) {
        i=-1;
        list=new ArrayList<>();
	    while(iterator.hasNext())
	    list.add(iterator.next());
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return list.get(i+1);
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    return list.get(++i);
	}
	
	@Override
	public boolean hasNext() {
	    if(i==list.size()-1)
        return false;
        return true;
	}
}