class Solution {
    int[][] dp,a;
    int m,n;
    public int dfs(int i,int j){
        if(i==m||j==n)
        return 0;
        if(i==m-1&&j==n-1)
        return 1;
        if(a[i][j]==1){
            dp[i][j]=0;
            return 0;
        }
        if(dp[i][j]!=-1)
        return dp[i][j];
        dp[i][j]=dfs(i,j+1)+dfs(i+1,j);
        return dp[i][j];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        a=obstacleGrid;
        m=a.length;
        n=a[0].length;
        dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        if(a[m-1][n-1]==1)
        return 0;
        return dfs(0,0);
    }
}