class Solution {
    List<List<Integer>> list;
    HashMap<List<Integer>,Integer> hm=new HashMap<>();
    public int dfs(int i,int j){
        if(j>=list.get(i).size())
        return Integer.MIN_VALUE;
        int s=list.get(i).get(j);
        if(i==list.size()-1)
        return s;
        List<Integer> l=Arrays.asList(i,j);
        if(hm.containsKey(l))
        return hm.get(l);
        s=s+Math.min(dfs(i+1,j),dfs(i+1,j+1));
        hm.put(l,s);
        return s;
    }
    public int minimumTotal(List<List<Integer>> triangle) {
     list=triangle;   
     return dfs(0,0);
    }
}