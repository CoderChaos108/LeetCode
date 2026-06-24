class Solution {
    int[][] dp;
    boolean[][] seen;
    public int find(int l,int r,int[] a){
        if(l>r)
        return 0;
        if(seen[l][r])
        return dp[l][r];
        seen[l][r]=true;
        int left=a[l]-find(l+1,r,a);
        int right=a[r]-find(l,r-1,a);
        return dp[l][r]=Math.max(left,right);
    }
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        dp=new int[n][n];
        seen=new boolean[n][n];
        return find(0,n-1,piles)>0;
    }
}