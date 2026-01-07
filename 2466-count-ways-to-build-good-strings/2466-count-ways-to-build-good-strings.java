class Solution {
    int mod=1000000007;
    int[] dp;
    public long count(int l,int low,int high,int zero,int one){
        if(l>high)
        return 0;
        if(dp[l]!=-1)
        return dp[l];
        int ret=0;
        if(l>=low&&l<=high){
            ret=1;
        }
        dp[l]=(int)((ret
        + count(l+one,low,high,zero,one)
        + count(l+zero,low,high,zero,one)) % mod);
        return dp[l];
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        dp=new int[high+1];
        for(int i=0;i<dp.length;i++)
        dp[i]=-1;
        return (int)count(0,low,high,zero,one);
    }
}