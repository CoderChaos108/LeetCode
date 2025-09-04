class Solution {
    boolean[] seen;
    List<Integer>[] graph;
    public void dfs(int node){
        if(seen[node])
        return;
        seen[node]=true;
        for(int neigh:graph[node])
        dfs(neigh);
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        graph=new ArrayList[n];
        for(int i=0;i<n;i++)
        graph[i]=new ArrayList<>(); 
        seen =new boolean[n];
        for(int[] a:invocations){
            graph[a[0]].add(a[1]);
        }
        dfs(k);
        List<Integer> list=new ArrayList<>();
        for(int[] a:invocations){
            if(seen[a[0]]^seen[a[1]]){
                for(int i=0;i<n;i++)
                list.add(i);
                return list;
            }
        }
        for(int i=0;i<n;i++){
            if(!seen[i])
            list.add(i);
        }
        return list;
    }
}