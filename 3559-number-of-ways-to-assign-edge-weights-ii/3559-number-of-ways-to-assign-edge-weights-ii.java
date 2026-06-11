class Solution {
    int n;
    int mod=1000000007;
    List<Integer>[] graph;
    int[] parent;
    int[][] up;
    int[] level;
    int d=0;
    public int pow(long a,long b){
        long res=1;
        while(b>0){
            if((b&1)!=0)
            res=((res*a)%mod);
            a=(a*a)%mod;
            b=b>>1;
        }
        return (int)(res%mod);
    }
    public void builder(int node,int par,int l){
        parent[node]=par;
        level[node]=l;
        d=Math.max(d,l);
        for(int neigh:graph[node]){
            if(neigh==par)
            continue;
            builder(neigh,node,l+1);
        }
    }
    public int kth(int node,int k){
        if(node==-1||k==0)
        return node;
        int log=(int)Math.floor(Math.log(k)/Math.log(2));
        int red=(int)(Math.pow(2,log));
        return kth(up[node][log],k-red);
    }
    public int lca(int u,int v){
        if(level[u]<level[v]){
            int temp=u;
            u=v;
            v=temp;
        }
        int k=level[u]-level[v];
        u=kth(u,k);
        if(u==v)
        return u;
        int log=(int)Math.floor(Math.log(d)/Math.log(2));
        for(int i=log;i>=0;i--){
            if(up[u][i]!=up[v][i]){
                u=up[u][i];
                v=up[v][i];
            }
        }
        return Math.max(1,parent[u]);
    }
    int[][] dp;
    public int find(int i,int parity){
        if(i==n-1)
        return parity;
        if(dp[i][parity]!=-1)
        return dp[i][parity];
        long res=find(i+1,0);
        res=res%mod;
        res=res+find(i+1,1);
        res=res%mod;
        dp[i][parity]=(int)res;
        return (int)res;
    }
    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        n=edges.length+1;
        level=new int[n+1];
        graph=new ArrayList[n+1];
        for(int i=1;i<=n;i++)
        graph[i]=new ArrayList<>();
        for(int[] arr:edges){
            int u=arr[0];
            int v=arr[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        parent=new int[n+1];
        builder(1,-1,0);
        dp=new int[n][2];
        for(int i=0;i<n;i++)
        for(int j=0;j<2;j++)
        dp[i][j]=-1;
        int log=(int)Math.floor(Math.log(n)/Math.log(2));
        up=new int[n+1][log+1];
        for(int i=1;i<=n;i++)
        up[i][0]=parent[i];
        for(int j=1;j<=log;j++){
            for(int i=1;i<=n;i++){
                if(up[i][j-1]!=-1)
                up[i][j]=up[up[i][j-1]][j-1];
                else
                up[i][j]=-1;
            }
        }
        find(0,0);
        int q=queries.length;
        int[] a=new int[q];
        for(int i=0;i<q;i++){
            int u=queries[i][0];
            int v=queries[i][1];
            int l=lca(u,v);
            int x=level[u]+level[v]-2*level[l];
            int ans=dp[n-x-1][0];
            if(u==v)
            ans=0;
            a[i]=ans;
        }
        return a;
    }
}