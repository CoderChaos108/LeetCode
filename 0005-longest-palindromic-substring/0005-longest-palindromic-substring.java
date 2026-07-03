class Solution {
    boolean[][] dp;
    int n;
    public String longestPalindrome(String s) {
        n=s.length();
        dp=new boolean[n][n];
            String ans="";
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                int j=i+k;
                if(j>=n)
                continue;
                char l=s.charAt(i);
                char r=s.charAt(j);
                if(l==r){
                    if(j-i+1<=2){
                        dp[i][j]=true;
                    }
                    else{
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                if(dp[i][j])
                ans=s.substring(i,j+1);
            }
        }
        return ans;
    }
}