class Solution {
    long[][][] dp;
    int m,n,k;
    int[][] a;
    int mod=1000000007;
    public int dfs(int i,int j,int s){
        if(i==m-1&&j==n-1){
            s=s+a[i][j];
            s=s%k;
            if(s==0)
            return 1;
            else 
            return 0;
        }
            if(dp[i][j][k]!=-1)
            return (int)dp[i][j][k];
            long paths=0;
            s=s+a[i][j];
            s=s%k;
            if(i+1!=m){
                paths=paths+dfs(i+1,j,s);
                paths=paths%mod;
            }
            if(j+1!=n){
                paths=paths+dfs(i,j+1,s);
                paths=paths%mod;
            }
            dp[i][j][s]=paths;
            return (int)paths;

    }
    public int numberOfPaths(int[][] grid, int k) {
        a=grid;
        m=grid.length;
        n=grid[0].length;
        this.k=k;
        dp=new long[m][n][k+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int l=0;l<=k;l++)
                dp[i][j][l]=-1;
            }
        }
        return dfs(0,0,0);
    }
}