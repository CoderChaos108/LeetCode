class Solution {
    int numComp;
    List<Integer>[] graph;
boolean[] seen;
    public void dfs(int node){
        if(seen[node])
        return;
        seen[node]=true;
        numComp++;
        for(int neigh:graph[node])
        dfs(neigh);
    }
    public long countPairs(int n, int[][] edges) {
        seen=new boolean[n];
         graph=new ArrayList[n];
        for(int i=0;i<n;i++)
        graph[i]=new ArrayList<>();
        for(int[] a:edges){
            int x=a[0];
            int y=a[1];
            graph[x].add(y);
            graph[y].add(x);
        }
        int nodesLeft=n;
        long ans=0;
        for(int i=0;i<n;i++){
            numComp=0;
            if(!seen[i])
            dfs(i);
            ans=ans+(nodesLeft-numComp)*numComp;
            nodesLeft=nodesLeft-numComp;
        }
        return ans;
    }
}