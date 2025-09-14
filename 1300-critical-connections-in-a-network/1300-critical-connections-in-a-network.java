class Solution {
    List<List<Integer>> bridge=new ArrayList<>(); 
    List<Integer>[] graph;
    int[] disc,low;
    int time=0;
    public void dfs(int node,int parent){
        disc[node]=low[node]=time++;
        for(int neigh:graph[node]){
            if(neigh==parent)
            continue;
            if(disc[neigh]!=-1){
                low[node]=Math.min(low[node],disc[neigh]);
            }
            else{
                dfs(neigh,node);
                low[node]=Math.min(low[node],low[neigh]);
                if(low[neigh]>disc[node]){
                    bridge.add(Arrays.asList(node,neigh));
                }
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        disc=new int[n];
        low=new int[n];
        graph=new ArrayList[n];
        for(int i=0;i<n;i++){
        graph[i]=new ArrayList<>();
        low[i]=disc[i]=-1;
        }
        for(List<Integer> list:connections){
            int x=list.get(0);
            int y=list.get(1);
            graph[x].add(y);
            graph[y].add(x);
        }
        for(int i=0;i<n;i++){
            if(disc[i]==-1)
            dfs(i,-1);
        }

        return bridge;
    }
}