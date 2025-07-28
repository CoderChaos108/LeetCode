class Solution {
    HashSet<Integer> set=new HashSet<>();
    int[][] a;
    public boolean safe(int n,HashSet seen){
        if(seen.contains(n)&&!set.contains(n))
        return false;
        if(set.contains(n))
        return true;
        seen.add(n);
        for(int i=0;i<a[n].length;i++){
            if(safe(a[n][i],seen)==false)
            return false;
        }
        set.add(n);
        return true;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        a=graph;
        for(int i=0;i<graph.length;i++){
            if(graph[i].length==0)
            set.add(i);
        }
        for(int i=-0;i<graph.length;i++){
        if(!set.contains(i))
        safe(i,new HashSet<>());
        }
        List<Integer> ans=new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }
}