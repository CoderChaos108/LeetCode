class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int l=start;
        int r=start;
        while(true){
            if(l>=0){
                if(target==nums[l])
                return start-l;
                l--;
            }
            if(r<nums.length){
                if(target==nums[r])
                return r-start;
                r++;
            }
        }
    }
}