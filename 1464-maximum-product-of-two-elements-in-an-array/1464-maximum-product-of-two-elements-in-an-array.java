class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n;i++)
        nums[i]--;
        return Math.max(nums[n-1]*nums[n-2],nums[0]*nums[1]);
    }
}