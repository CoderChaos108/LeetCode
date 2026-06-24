class Solution {
    int[][] dp;
    public int find(int l,int r,int[] a){
        if(l>r)
        return 0;
        if(dp[l][r]!=-1)
        return dp[l][r];
        int left=a[l]-find(l+1,r,a);
        int right=a[r]-find(l,r-1,a);
        return dp[l][r]=Math.max(left,right);
    }
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        dp=new int[n][n];
        for(int i=0;i<n;i++)
        Arrays.fill(dp[i],-1);
        return find(0,n-1,piles)>0;
    }
}