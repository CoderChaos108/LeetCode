class Solution {
    List<List<Integer>> graph=new ArrayList<>();
    boolean[] seen;
    public void dfs(int node){
        if(seen[node])
        return;
        seen[node]=true;
        for(int neigh:graph.get(node))
        dfs(neigh);
    }
    public int findChampion(int n, int[][] edges) {
        seen=new boolean[n];
        for(int i=0;i<n;i++)
        graph.add(new ArrayList<>());
        for(int[] a:edges){
            graph.get(a[0]).add(a[1]);
        }
        for(int i=0;i<n;i++){
            if(!seen[i]){
            dfs(i);
            seen[i]=false;
            }
        }
        int champ=-1;
        for(int i=0;i<n;i++){
            if(!seen[i]){
                if(champ==-1)
                champ=i;
                else
                return -1;
            }
        }
        return champ;
    }
}