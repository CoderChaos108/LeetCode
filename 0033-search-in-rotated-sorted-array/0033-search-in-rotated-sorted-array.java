class Solution {
    public int search(int[] nums, int target) {
        int l=0;
        int ml=nums.length/2;
        int mr=ml;
        int r=nums.length-1;
        while(l<=ml||mr<=r){
            if(nums[r]==target)
            return r;
            if(nums[l]==target)
            return l;
            if(nums[mr]==target)
            return mr;
            if(nums[ml]==target)
            return ml;
            r--;
            mr++;
            ml--;
            l++;
            
        }
        return -1;
    }
}