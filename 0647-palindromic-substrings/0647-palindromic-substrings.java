class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        int ans=0;
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                int j=i+k;
                if(j>=n)
                break;
                char l=s.charAt(i);
                char r=s.charAt(j);
                if(l==r){
                    if(j-i+1<=2||dp[i+1][j-1]){
                    dp[i][j]=true;
                    ans++;
                    }
                }
            }
        }
        return ans;
    }
}