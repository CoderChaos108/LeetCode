class Solution {
    int mod=1000000007;
    int[][][] dp;
    int n,m,k;
    public int find(int i,int max,int cost){
        if(cost>k)
        return 0;
        if(i==n){
        if(cost==k)
        return 1;
        return 0;
    }
        if(dp[i][max][cost]!=-1)
        return dp[i][max][cost];
        long ans=0;
        for(int j=max+1;j<=m;j++){
            ans=ans+find(i+1,j,cost+1);
            ans=ans%mod;
        }
        ans=ans+((long)max)*(find(i+1,max,cost));
        ans=ans%mod;
        dp[i][max][cost]=(int)ans;
        return (int)ans;
    }
    public int numOfArrays(int n, int m, int k) {
        this.n=n;
        this.m=m;
        this.k=k;
        dp=new int[n][m+1][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=m;j++){
                for(int l=0;l<=k;l++)
                dp[i][j][l]=-1;
            }
        }
        return find(0,0,0);
    }
}