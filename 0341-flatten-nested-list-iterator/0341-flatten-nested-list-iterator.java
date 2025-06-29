/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private int p;
     private List<Integer> list;
    public NestedIterator(List<NestedInteger> nestedList) {
        list=new ArrayList<>();
        listMaker(nestedList);
        p=0;
    }
    public void listMaker(List<NestedInteger> nestList){
        for(int i=0;i<nestList.size();i++){
            if(nestList.get(i).isInteger())
            list.add(nestList.get(i).getInteger());
            else{
                listMaker(nestList.get(i).getList());
            }
        }
    }
    @Override
    public Integer next() {
        return list.get(p++);
    }

    @Override
    public boolean hasNext() {
        if(p<list.size())
        return true;
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */