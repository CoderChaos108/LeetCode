class Solution {
    int[] dp;
    int n;
    int min=Integer.MIN_VALUE;
    public int find(int i,int[] a){
        if(i==n)
        return 0;
        int left=n-i;
        int three=0;
        int two=0;
        if(dp[i]!=min)
        return dp[i];
        int ans=a[i]-find(i+1,a);
        if(left>=2)
        ans=Math.max(ans,a[i]+a[i+1]-find(i+2,a));
        if(left>=3)
        ans=Math.max(ans,a[i]+a[i+1]+a[i+2]-find(i+3,a));
        return dp[i]=ans;
    }
    public String stoneGameIII(int[] stoneValue) {
        n=stoneValue.length;
        dp=new int[n];
        Arrays.fill(dp,min);
        int ans=find(0,stoneValue);
        if(ans>0)
        return "Alice";
        if(ans==0)
        return "Tie";
        return "Bob";
    }
}