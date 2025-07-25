class Solution {
    int c;
    boolean[] res;
    public void dfs(int node,List<Integer>[] a){
        if(res[node])return;
        c++;
        res[node]=true;
        for(int i:a[node])
        dfs(i,a);
    }
    public int reachableNodes(int n,int[][] edges,int[] restricted) {
        c=0;
        res=new boolean[n];
        List<Integer>[] a=new ArrayList[n];
        for(int i=0;i<n;i++)
        a[i]=new ArrayList<>();
        for(int i=0;i<edges.length;i++){
            int x=edges[i][0];
            int y=edges[i][1];
            a[x].add(y);
            a[y].add(x);
        }
        for(int i:restricted)
        res[i]=true;
        dfs(0,a);
        return c;
    }
}
