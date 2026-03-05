class Solution {
    int[] dp;
    public int split(int n){
        if(dp[n]!=0)
        return dp[n];
        int ans=0;
        for(int i=1;i<=n/2;i++){
            int j=n-i;
            ans=Math.max(ans,split(i)*split(j));
        }
        ans=Math.max(ans,n);
        dp[n]=ans;
        return ans;
    }
    public int integerBreak(int n) {
        dp=new int[n];
        int ans=1;
        for(int i=1;i<=n/2;i++){
            int j=n-i;
            ans=Math.max(ans,split(i)*split(j));
        }
        return ans;
    }
}