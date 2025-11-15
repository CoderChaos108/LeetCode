class Solution {
    public int jump(int[] nums) {
        int farthest=0;
        int currEnd=0;
        int jumps=0;
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            farthest=Math.max(farthest,nums[i]+i);
            if(i==currEnd){
                currEnd=farthest;
                jumps++;
            }
        }
        return jumps;
    }
}