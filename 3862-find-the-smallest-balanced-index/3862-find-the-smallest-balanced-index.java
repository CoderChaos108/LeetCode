class Solution {
    public int smallestBalancedIndex(int[] nums) {
        double[] pre=new double[nums.length];
        double[] post=new double[nums.length];
        double sum=0;
        for(int i=0;i<nums.length;i++){
            pre[i]=sum;
            sum=sum+nums[i];
        }
        double pro=1;
        for(int i=nums.length-1;i>=0;i--){
            post[i]=pro;
            pro=pro*nums[i];
        }
        for(int i=0;i<nums.length;i++){
            if(pre[i]==post[i])
            return i;
        }
        return -1;
    }
}