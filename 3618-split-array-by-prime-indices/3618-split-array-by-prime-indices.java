class Solution {
    public long splitArray(int[] nums) {
        long ans=0;
        long nonPrimes=0;
        nonPrimes=nums[0];;
        if(nums.length>1)
        nonPrimes=nonPrimes+nums[1];
        for(int i:nums)
        ans=ans+i;
        int n=nums.length-1;
        for(int i=2;i*i<=n;i++){
            for(int j=i;i*j<=n;j++){
              nonPrimes=nonPrimes+nums[i*j];
            }
        }
        ans=ans-nonPrimes;
        return Math.abs(ans-nonPrimes);
    }
}