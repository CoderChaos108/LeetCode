class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int max=-1;
        int min=Integer.MAX_VALUE;
        for(int i:nums){
            max=Math.max(max,i);
            min=Math.min(min,i);
        }
        long ans=max-min;
        ans=k*ans;
        return ans;
    }
}