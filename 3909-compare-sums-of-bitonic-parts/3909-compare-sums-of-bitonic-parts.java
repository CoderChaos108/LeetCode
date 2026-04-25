class Solution {
    public int compareBitonicSums(int[] nums) {
        int peak=-1;
        int j=-1;
        long t=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>peak){
                peak=nums[i];
                j=i;
            }
            t=t+nums[i];
        }
        long s=0;
        for(int i=0;i<=j;i++){
            s=s+nums[i];
        }
        t=t-s+peak;
        if(t==s)
        return -1;
        if(s>t)
        return 0;
        return 1;
    }
}