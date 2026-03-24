class Solution {
    int[][] dp;
    int m,n;
    public int fall(int i,int j,int[][] grid){
        if(i==m-1){
            return grid[i][j];
        }
        if(dp[i][j]!=Integer.MAX_VALUE)
        return dp[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=0;k<n;k++){
            if(k!=j)
            min=Math.min(fall(i+1,k,grid),min);
        }
        dp[i][j]=min+grid[i][j];
        return dp[i][j];
    }
    public int minFallingPathSum(int[][] matrix) {
         m=matrix.length;
        n=matrix[0].length;
        dp=new int[m][n];
        for(int[] a:dp)
        Arrays.fill(a,Integer.MAX_VALUE);
        int ans=Integer.MAX_VALUE;
        for (int j=0;j<n;j++) {
            ans=Math.min(ans,fall(0,j,matrix));
        }
        return ans;
    }
}