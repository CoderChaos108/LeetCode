class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] prefix=new int[nums.length];
        int s=0;
        for(int i=0;i<nums.length;i++){
            prefix[i]=s;
            s=s+nums[i];
        }
        s=0;
        int[] suffix=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            suffix[i]=s;
            s=s+nums[i];
        }
        int[] res=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int pre=i;
            int diff=pre*nums[i]-prefix[i];
            int post=nums.length-1-i;
            diff=diff+suffix[i]-post*nums[i];
            res[i]=diff;
        }
        return res;
    }
}