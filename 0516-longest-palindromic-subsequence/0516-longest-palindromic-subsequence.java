class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];
        int ans=0;
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                int j=i+k;
                if(j>=n)
                break;
                char l=s.charAt(i);
                char r=s.charAt(j);
                if(l==r){
                    if(j-i+1<=2){
                        dp[i][j]=j-i+1;
                    }
                    else
                    dp[i][j]=dp[i+1][j-1]+2;
                }
                else{
                    if(i+1<n&&j-1>=0)
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
                ans=Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }
}