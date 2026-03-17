class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int r=0;
        for(int i:piles){
            r=Math.max(i,r);
        }
        int ans=Integer.MAX_VALUE;
        while(l<=r){
            int k=(l+r)/2;
            long hours=0;
            for(int i:piles){
                double n=i;
                n=n/k;
                n=Math.ceil(n);
                hours=hours+(int)n;
            }
            if(hours<=h){
                ans=Math.min(ans,k);
                r=k-1;
            }
            else{
                l=k+1;
            }
        }
        return ans;
    }
}