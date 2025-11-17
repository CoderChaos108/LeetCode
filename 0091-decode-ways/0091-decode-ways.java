class Solution {
    int[] dp;
    int n;
    String s;
    public int find(int k,int val){
        if(val>26||val<1)
        return 0;
        if(k==n)
        return 1;
        if(k>n)
        return 0;
        if(dp[k]!=-1)
        return dp[k];
        if(s.charAt(k)=='0')
        return 0;
        dp[k]=find(k+1,s.charAt(k)-'0');
        if(k!=n-1){
            dp[k]=dp[k]+find(k+2,(s.charAt(k)-'0')*10+s.charAt(k+1)-'0');
        }
        return dp[k];
    }
    public int numDecodings(String s) {
        this.s=s;
        n=s.length();
        dp=new int[n];
        Arrays.fill(dp,-1);
        return find(0,1);
    }
}