class Solution {
    int[] dp;
    public int climb(int n){
        if(n==0||n==1||n==2)
        return n;
        if(dp[n]!=0)
        return dp[n];
        dp[n]=climb(n-1)+climb(n-2);
        return dp[n];
    }
    public int climbStairs(int n) {
        dp=new int[n+1];
        return climb(n);
    }
}