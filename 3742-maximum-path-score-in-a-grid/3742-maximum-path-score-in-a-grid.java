class Solution {
    int m,n;
    int[][][] dp;
    public int find(int i,int j,int k,int[][] a){
        int s=a[i][j];
        if(a[i][j]!=0)
        k=k-1;
        if(k<0)
        return Integer.MIN_VALUE;
        if(i==m-1&&j==n-1){
            if(k>=0)
            return s;
            else
            return Integer.MIN_VALUE;
        }
        if(dp[i][j][k]!=-1)
        return dp[i][j][k];
        int res=Integer.MIN_VALUE;
        int[][] dirs={{0,1},{1,0}};
        for(int[] d:dirs){
            int ni=i+d[0];
            int nj=j+d[1];
            if(ni<0||nj<0||ni>=m||nj>=n)
            continue;
            int add=find(ni,nj,k,a);
            if(add==Integer.MIN_VALUE)
            continue;
            res=Math.max(res,s+add);
        }
        dp[i][j][k]=res;
        return res;
    }
    public int maxPathScore(int[][] grid, int k) {
        m=grid.length;
        n=grid[0].length;
        dp=new int[m][n][k+1];
        for(int i=0;i<m;i++)
        for(int j=0;j<n;j++)
        for(int l=0;l<=k;l++)
        dp[i][j][l]=-1;
        int ans=find(0,0,k,grid);
        if(ans<0)
        return -1;
        return ans;
    }
}