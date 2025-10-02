class SmallestInfiniteSet {
    TreeSet<Integer> set;
    int min;
    public SmallestInfiniteSet() {
        set=new TreeSet<>();
        min=0;
    }
    
    public int popSmallest() {
        if(set.isEmpty())
        return ++min;
        return set.pollFirst();
    }
    public void addBack(int num) {
           if(num<=min)
           set.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */