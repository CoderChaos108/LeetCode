class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] set=new boolean[n];
        for(List<Integer> a:edges){
            set[a.get(1)]=true;
        }
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!set[i])
            list.add(i);
        }
        return list;
    }
}