class Solution {
    public int maxSubArray(int[] nums) {
        int s=0;
        int max=Integer.MIN_VALUE;
        for(int i:nums){
            s=s+i;
            max=Math.max(s,max);
            if(s<0)
            s=0;
        }
        return max;
    }
}