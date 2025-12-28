class Solution {
    public long maximumScore(int[] nums) {
        long ans=Integer.MIN_VALUE;
        long[] prefix=new long[nums.length];
        int itr=0;
        long s=0;
        for(int i:nums){
            s=s+i;
            prefix[itr++]=s;
        }
        int min=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            ans=Math.max(prefix[i]-min,ans);
            min=Math.min(min,nums[i]);
        }
        return ans;
    }
}