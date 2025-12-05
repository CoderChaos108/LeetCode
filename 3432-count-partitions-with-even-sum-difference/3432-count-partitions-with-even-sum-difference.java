class Solution {
    public int countPartitions(int[] nums) {
        int ans=0;
        int totalSum=0;
        int s=0;
        for(int i:nums)
        totalSum=totalSum+i;
        for(int i=0;i<nums.length-1;i++){
            s=s+nums[i];
            totalSum=totalSum-nums[i];
            if((totalSum-s)%2==0)
            ans++;
        }
        return ans;
    }
}