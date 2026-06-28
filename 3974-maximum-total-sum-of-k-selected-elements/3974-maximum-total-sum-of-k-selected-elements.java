class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);
        long ans=0;
        int idx=nums.length-1;
        while(k!=0&&mul!=1){
            ans=ans+(long)mul*nums[idx];
            idx--;
            mul--;
            k--;
        }
        while(idx>=0&&k!=0){
            ans=ans+nums[idx--];
            k--;
        }
        return ans;
    }
}