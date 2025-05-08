class Solution {
    public boolean search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        int ml=l+r/2;
        int mr=ml;
        while(l<=ml||mr<=r){
            if(nums[l]==target||nums[ml]==target||nums[mr]==target||nums[r]==target)
            return true;
            l++;
            ml--;
            r--;
            mr++;
        }
        return false;
    }
}