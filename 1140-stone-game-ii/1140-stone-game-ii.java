class Solution {
    int[][][] dp;
    int n;
    public int find(int i,int m,int turn,int[] a){
        m=Math.min(m,n);
        if(i>=n)
        return 0;
        turn=turn%2;
        if(dp[i][m][turn]!=-1)
        return dp[i][m][turn];
        int s=0;
        int res=0;
        if(turn==0)
        res=Integer.MIN_VALUE;
        else
        res=Integer.MAX_VALUE;
        for(int j=i;j<i+2*m&&j<n;j++){
            s=s+a[j];
           int take=find(j+1,Math.max(m,j-i+1),turn+1,a);
           if(turn==0)
           take=s+take;
           if(turn==0)
           res=Math.max(res,take);
           else
           res=Math.min(res,take);
        }
        return dp[i][m][turn]=res;
    }
    public int stoneGameII(int[] piles) {
        n=piles.length;
        dp=new int[n][n+1][2];
        for(int i=0;i<n;i++)
        for(int j=0;j<=n;j++)
        for(int k=0;k<2;k++)
        dp[i][j][k]=-1;
        return find(0,1,0,piles);
    }
}