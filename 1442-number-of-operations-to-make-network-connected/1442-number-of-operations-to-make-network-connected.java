class Solution {
    boolean[] seen;
    List<List<Integer>> graph=new ArrayList<>();
    int cables=0;
    public void dfs(int node){
        if(seen[node]){
        return;
        }
        seen[node]=true;
        for(int neigh:graph.get(node)){
        dfs(neigh);
        }
    }
    public int makeConnected(int n, int[][] connections) {
        cables=connections.length-n+1;
        if(cables<0)
        return -1;
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
                    dfs(i);
                }
            }
            return c;
    }
}