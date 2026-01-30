class Solution {
    public int find(int[] nums,int[] dp,int i){
        if(dp[i]!=-1)
        return dp[i];
        int max=1;
        for(int j=i+1;j<nums.length;j++){
            if(nums[j]>nums[i]){
                max=Math.max(max,1+find(nums,dp,j));
            }
        }
        dp[i]=max;
        return max;
    }
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            dp[i]=-1;
        }
        for(int i=0;i<nums.length;i++){
            find(nums,dp,i);
        }
        int ans=0;
        for(int i=0;i<nums.length;i++)
        ans=Math.max(dp[i],ans);
        return ans;
    }
}