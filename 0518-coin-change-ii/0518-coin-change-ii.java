class Solution {
    int[][] dp;
    public int find(int i,int amount,int[] coins){
        if(amount<0)
        return 0;
        if(amount==0)
        return 1;
        if(i>=coins.length)
        return 0;
        if(dp[amount][i]!=-1)
        return dp[amount][i];
        int ways=0;
        ways=find(i,amount-coins[i],coins)+find(i+1,amount,coins);
        dp[amount][i]=ways;
        return ways;
    }
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        dp=new int[amount+1][coins.length];
        for(int[] a:dp)
        Arrays.fill(a,-1);
        return find(0,amount,coins);
    }
}