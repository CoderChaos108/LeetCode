class Solution {
    List<List<Integer>> graph=new ArrayList<>();
    boolean[] seen;
    HashSet<Integer> set=new HashSet<>();
    
    public void check(int node){
        if(seen[node]){
            set.remove(node);
            return;
        }
        seen[node]=true;
        for(int i:graph.get(node))
            check(i);
    }
    
    public List<Integer> findSmallestSetOfVertices(int n,List<List<Integer>> edges){
        seen=new boolean[n];
        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());
        for(List<Integer> a:edges)
            graph.get(a.get(0)).add(a.get(1));
        for(int i=0;i<n;i++){
            if(!seen[i]){
                set.add(i);
                check(i);
            }
        }
        return new ArrayList<>(set);
    }
}
