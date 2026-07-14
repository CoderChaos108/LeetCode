class Solution {
    int[][] dp;
    
    public int find(int l,int r){
        if(l>=r)
        return 0;
        int n=dp.length-1;
        int res=Integer.MAX_VALUE;
        if(dp[l][r]!=-1)
        return dp[l][r];
        for(int j=l;j<=r;j++){
            int max=Math.max(find(l,j-1),find(j+1,r));
            res=Math.min(res,j+max);
        }
        return dp[l][r]=res;
    }
    public int getMoneyAmount(int n) {
        dp=new int[n+1][n+1];
        for(int i=0;i<=n;i++)
        for(int j=0;j<=n;j++)
        dp[i][j]=-1;
        return find(1,n);
        
    }
}