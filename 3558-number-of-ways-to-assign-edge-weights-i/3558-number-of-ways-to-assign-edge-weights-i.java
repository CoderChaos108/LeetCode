class Solution {
    int n;
    int[][] dp;
    int d=0;
    int mod=1000000007;
    List<Integer>[] graph;
    public int dfs(int node,List<Integer>[] graph,int parent){
        int dis=0;
        for(int neigh:graph[node]){
            if(neigh==parent)
            continue;
            dis=Math.max(dis,1+dfs(neigh,graph,node));
        }
        return dis;
    }
    public int find(int i,int parity){
        if(i==d)
        return parity;
        long res=0;
        if(dp[i][parity]!=-1)
        return dp[i][parity];
        res=res+find(i+1,0);
        res=res%mod;
        res=res+find(i+1,1);
        res=res%mod;
        dp[i][parity]=(int)res;
        return dp[i][parity];
    }
    public int assignEdgeWeights(int[][] edges) {
        n=edges.length+1;
        graph=new ArrayList[n+1];
        for(int i=1;i<=n;i++)
        graph[i]=new ArrayList<>();
        for(int[] arr:edges){
            int u=arr[0];
            int v=arr[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        d=dfs(1,graph,-1);
        dp=new int[d+1][2];
        for(int i=0;i<=d;i++)
        for(int j=0;j<2;j++)
        dp[i][j]=-1;
        return find(0,0);
    }
}