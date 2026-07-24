class Solution {
    int[][][] dp;
    public int find(int i,int m,int n,String[] a){
        if(i==a.length)
        return 0;
        if(m>=dp[0].length||n>=dp[0][0].length)
        return Integer.MIN_VALUE;
        if(dp[i][m][n]!=-1)
        return dp[i][m][n];
        String s=a[i];
        int p=0;
        int q=0;
        for(int j=0;j<s.length();j++){
            if(s.charAt(j)=='0')
            p++;
            else
            q++;
        }
        int take=Integer.MIN_VALUE;

if(m+p<dp[0].length && n+q<dp[0][0].length)
    take=1+find(i+1,m+p,n+q,a);

int skip=find(i+1,m,n,a);

return dp[i][m][n]=Math.max(take,skip);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        dp=new int[strs.length][m+1][n+1];
        for(int i=0;i<strs.length;i++)
        for(int j=0;j<=m;j++)
        for(int k=0;k<=n;k++)
        dp[i][j][k]=-1;
        return find(0,0,0,strs);
    }
}