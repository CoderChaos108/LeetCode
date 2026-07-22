class Solution {
    int[][] dp;
    int n;
    int s=0;
    public boolean find(int i,int left,int[] a){
        if(2*left==s)
        return true;
        if(2*left<s||i>=n)
        return false;
        if(dp[i][left]!=0)
        return dp[i][left]==1;
        boolean res=false;
        res=find(i+1,left,a)||find(i+1,left-a[i],a);
        if(res)
        dp[i][left]=1;
        else
        dp[i][left]=-1;
        return res;
    }
    public boolean canPartition(int[] nums) {
        n=nums.length;        
        for(int i:nums)
        s=s+i;
        if(s%2!=0)
        return false;
        dp=new int[n][s+1];
        return find(0,s,nums);
    }
}