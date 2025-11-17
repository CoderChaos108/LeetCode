class Solution {
    int m,n;
    int[][] dp;
    public int dfs(int i,int j){
        if(i<0||j<0||i==m||j==n)
        return 0;
        if(i==m-1&&j==n-1)
        return 1;
        if(dp[i][j]!=0)
        return dp[i][j];
        dp[i][j]=dfs(i+1,j)+dfs(i,j+1);
        return dp[i][j];
    }
    public int uniquePaths(int m, int n) {
        dp=new int[m][n];
        this.m=m;
        this.n=n;
        return dfs(0,0);
    }
}