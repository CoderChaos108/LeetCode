class Solution {
    boolean[] seen;
    List<List<Integer>> graph=new ArrayList<>();
    int cables=0;
    public void dfs(int node,int parent){
        if(seen[node]){
        cables++;
        return;
        }
        seen[node]=true;
        for(int neigh:graph.get(node)){
        if(neigh!=parent)
        dfs(neigh,node);
        }
    }
    public int makeConnected(int n, int[][] connections) {
        for(int i=0;i<n;i++)
        graph.add(new ArrayList<>());
        for(int[] a:connections){
            int x=a[0];
            int y=a[1];
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
            seen=new boolean[n];
            int c=-1;
            for(int i=0;i<n;i++){
                if(!seen[i]){
                    c++;
                    dfs(i,-1);
                }
            }
            if(cables/2<c)
            return -1;
            return c;
    }
}