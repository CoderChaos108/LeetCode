class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l=1;
        int r=0;
        for(int i:nums)
        r=Math.max(r,i);
        int ans=Integer.MAX_VALUE;
        while(l<=r){
            int div=(l+r)/2;
            int s=0;
            for(int i:nums){
                double n=i;
                n=n/div;
                n=Math.ceil(n);
                s=s+(int)n;
            }
            if(s<=threshold){
                ans=Math.min(ans,div);
                r=div-1;
            }
            else{
                l=div+1;
            }
        }
        return ans;
    }
}