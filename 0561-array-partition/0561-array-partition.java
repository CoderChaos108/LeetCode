class Solution {
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int s=0;
        int l=nums.length-1;
        for(int i=0;i<l;i=i+2){
            s=s+Math.min(nums[i],nums[i+1]);
        }
        return s;
    }
}