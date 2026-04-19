class Solution {
    int[][][][] dp;
    int n;

    public int robber(int pos,int start,int[] nums,int lastRobbed,int taken){
        if(pos==n)
        return 0;

        if(dp[pos][start][lastRobbed][taken]!=-1)
        return dp[pos][start][lastRobbed][taken];

        int idx=(start+pos)%n;
        int cash=0;

        if(lastRobbed==1){
            cash=robber(pos+1,start,nums,0,taken);
        }
        else{
            int skip=robber(pos+1,start,nums,0,taken);
            int take=0;

            if(pos!=n-1||taken==0)
            take=nums[idx]+robber(pos+1,start,nums,1,(pos==0)?1:taken);

            cash=Math.max(skip,take);
        }

        dp[pos][start][lastRobbed][taken]=cash;
        return cash;
    }

    public int rob(int[] nums) {
        n=nums.length;

        if(n==1)
        return nums[0];

        dp=new int[n][n][2][2];

        for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
        for(int k=0;k<2;k++)
        for(int l=0;l<2;l++)
        dp[i][j][k][l]=-1;

        int ans=0;

        for(int start=0;start<n;start++)
        ans=Math.max(ans,robber(0,start,nums,0,0));

        return ans;
    }
}