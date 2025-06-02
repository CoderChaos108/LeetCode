class Solution {
    public int[] productExceptSelf(int[] nums) {
        int p=1;
        int pre[]=new int[nums.length];
        int post[]=new int[nums.length];
        pre[0]=1;
        for(int i=0;i<nums.length-1;i++){
            p=p*nums[i];
            pre[i+1]=p;
        }
        post[nums.length-1]=1;
        p=1;
        for(int i=nums.length-1;i>0;i--){
            p=p*nums[i];
            post[i-1]=p;
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=pre[i]*post[i];
        }
        return nums;
    }
}