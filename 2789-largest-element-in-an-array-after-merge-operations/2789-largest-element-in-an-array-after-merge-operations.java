class Solution {
    public long maxArrayValue(int[] nums) {
        int n=nums.length;
        long ans=nums[n-1];
        long curr=ans;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<=curr){
                curr=curr+nums[i];
            }
            else
            curr=nums[i];
            ans=Math.max(ans,curr);
        }
        return ans;
    }
}