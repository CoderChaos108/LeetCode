class Solution {
    int[][][] dp;
    int[][] dirs={
        {1,-1},{1,0},{1,1}
    };
    public int find(int i,int j1,int j2,int[][] a){
        int m=a.length;
        int n=a[0].length;
        if(i==m-1){
            if(j1==j2)
            return a[i][j1];
            return a[i][j1]+a[i][j2];
        }
        if(dp[i][j1][j2]!=-1)
        return dp[i][j1][j2];
        int ans=0;
        if(j1==j2)
        ans=a[i][j1];
        else
        ans=a[i][j1]+a[i][j2];
        int decisions=0;
        for(int[] d1:dirs){
            int nj1=d1[1]+j1;
            if(nj1<0||nj1>=n)
            continue;
            for(int[] d2:dirs){
                int nj2=d2[1]+j2;
                if(nj2<0||nj2>=n)
                continue;
                decisions=Math.max(decisions,find(i+1,nj1,nj2,a));
            }
        }
        ans=ans+decisions;
        dp[i][j1][j2]=ans;
        return ans;
    }
    public int cherryPickup(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        dp=new int[m][n][n];
        for(int i=0;i<m;i++)
        for(int j=0;j<n;j++)
        for(int k=0;k<n;k++)
        dp[i][j][k]=-1;
        return find(0,0,n-1,grid);
    }
}