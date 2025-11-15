class Solution {
    int[] nums,dp;
    int n;
    public int rob(int k){
        if(dp[k]!=-1)
        return dp[k];
        if(k==n-1||k==n-2){
            dp[k]=nums[k];
        return nums[k];
        }
        int cash=0;
        for(int i=k+2;i<n;i++){
            cash=Math.max(cash,rob(i));
        }
        dp[k]=nums[k]+cash;
        return dp[k];
    }
    public int rob(int[] nums) {
        this.nums=nums;
        n=nums.length;
        dp=new int[n];
        for(int i=0;i<n;i++)
        dp[i]=-1;
        for(int i=0;i<n;i++)
        rob(i);
        int ans=0;
        for(int i=0;i<n;i++)
        ans=Math.max(dp[i],ans);
        return ans;
    }
}