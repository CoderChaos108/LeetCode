class Solution {
    public int maximumDifference(int[] nums) {
        int l=-1;
        int s=nums[0];
        for(int i=1;i<nums.length;i++){
            if(s==nums[i])
            continue;
            if(nums[i]-s>l)
            l=nums[i]-s;
            else if(nums[i]<s)
            s=nums[i];
        }
        return l;
    }
}