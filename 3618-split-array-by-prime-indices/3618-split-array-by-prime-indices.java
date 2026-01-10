class Solution {
    public long splitArray(int[] nums) {
        long prime=0;
        long nonPrime=0;
        for(int n=0;n<nums.length;n++){
            boolean isPrime=true;
            for(int i=2;i*i<=n;i++){
                if(n%i==0){
                    isPrime=false;
                    break;
                }
            }
            if(n<2){
                    isPrime=false;
                }
            if(isPrime)
            prime=prime+nums[n];
            else
            nonPrime=nonPrime+nums[n];
        }
        return Math.abs(prime-nonPrime);
    }
}