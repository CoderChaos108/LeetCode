class Solution {
    boolean[] seen;
    List<Integer>[] graph;
    List<Integer> list;
    public void dfs(int node){
        for(int neigh:graph[node]){
        if(!seen[neigh]){
        seen[neigh]=true;
        list.add(neigh);
        dfs(neigh);
        }
        }
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        seen=new boolean[n];
        graph=new ArrayList[n];
        for(int i=0;i<n;i++)
        graph[i]=(new ArrayList<>());
        for(int[] a:edges){
            graph[a[1]].add(a[0]);
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            list=new ArrayList<>();
            seen[i]=true;
            dfs(i);
            Collections.sort(list);
            ans.add(list);
            seen=new boolean[n];
        }
        return ans;
    }
}