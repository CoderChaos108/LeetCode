class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] nums) {
        Arrays.sort(nums);
        nums[0]=1;
        for(int i=0;i<nums.length-1;i++){
            nums[i+1]=Math.min(nums[i+1],nums[i]+1);
        }
        return nums[nums.length-1];
    }
}