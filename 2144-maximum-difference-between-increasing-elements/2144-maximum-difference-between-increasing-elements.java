class Solution {
    public int maximumDifference(int[] nums) {
        int l=0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]-nums[i]>l)
                l=nums[j]-nums[i];
            }
        }
        if(l==0)
        return -1;
        return l;
    }
}