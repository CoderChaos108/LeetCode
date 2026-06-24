class Solution {
    int[] dp;
    public int find(int i,int k,int[] a){
        if(i>=a.length)
        return 0;
        if(dp[i]!=-1)
        return dp[i];
        int s=0;
        int res=0;
        for(int j=i;j<a.length&&j<i+k;j++){
            s=Math.max(s,a[j]);
            res=Math.max(res,s*(j-i+1)+find(j+1,k,a));
        }

        return dp[i]=res;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp=new int[arr.length];
        Arrays.fill(dp,-1);
        return find(0,k,arr);
    }
}