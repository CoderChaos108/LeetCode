class Solution {
    int[][][] dp;

    public int robber(int i,int end,int[] nums,int lastRobbed){
        if(i>end)
        return 0;

        if(dp[i][end][lastRobbed]!=-1)
        return dp[i][end][lastRobbed];

        int cash=0;

        if(lastRobbed==1){
            cash=robber(i+1,end,nums,0);
        }
        else{
            int take=nums[i]+robber(i+1,end,nums,1);
            int skip=robber(i+1,end,nums,0);
            cash=Math.max(take,skip);
        }

        dp[i][end][lastRobbed]=cash;
        return cash;
    }

    public int rob(int[] nums) {
        int n=nums.length;

        if(n==1)
        return nums[0];

        dp=new int[n][n][2];

        for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
        for(int k=0;k<2;k++)
        dp[i][j][k]=-1;

        int a=robber(0,n-2,nums,0);
        int b=robber(1,n-1,nums,0);

        return Math.max(a,b);
    }
}