class TreeAncestor {
    int[][] up;
    public TreeAncestor(int n, int[] parent) {
        up=new int[n][(int)Math.floor(Math.log(n))+1];
        int log=up[0].length;
        for(int i=0;i<n;i++)
        up[i][0]=parent[i];
        for(int j=1;j<log;j++){
            for(int i=0;i<n;i++){
                if(up[i][j-1]!=-1)
                up[i][j]=up[up[i][j-1]][j-1];
                else
                up[i][j]=-1;
            }
        }
    }
    public int lca(int node,int k){
        if(node==-1)
        return -1;
        if(k==0)
        return node;
        int log=(int)Math.floor(Math.log(k));
        int red=(int)(Math.pow(2,log));
        return lca(up[node][log],k-red);
    }
    public int getKthAncestor(int node, int k) {
        return lca(node,k);
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */