class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            int steps=Math.abs(nums[i])%n;
            if(nums[i]>=0){
                int j=(i+steps)%n;
                ans[i]=nums[j];
            }
            else{
                int j=(i-steps)%n;
                if(j<0)
                j=n+j;
                ans[i]=nums[j];
            }
        }
        return ans;
    }
}