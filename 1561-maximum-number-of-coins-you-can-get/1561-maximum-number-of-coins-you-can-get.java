class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int l=0;
        int n=piles.length;
        int r=n-1;
        int ans=0;
        while(l<=r){
            ans=piles[r-1]+ans;
            l++;
            r=r-2;
        }
        return ans;
    }
}