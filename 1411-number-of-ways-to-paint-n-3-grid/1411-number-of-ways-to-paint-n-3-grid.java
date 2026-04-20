class Solution {
    int mod=1000000007;
    long[][][][] dp;
    public long find(int p,int[] last,int n){
        if(p>n)
        return 1;
        int a=last[0];
        int b=last[1];
        int c=last[2];
        if(a!=-1&&dp[p][a][b][c]!=-1)
        return dp[p][a][b][c];
        long res=0;
        for(int i=0;i<3;i++){
            if(i==a)
            continue;
            for(int j=0;j<3;j++){
                if(j==i||j==b)
                continue;
                for(int k=0;k<3;k++){
                    if(k==j||k==c)
                    continue;
                    last[0]=i;
                    last[1]=j;
                    last[2]=k;
                    res=res+find(p+1,last,n);
                    res=res%mod;
                }
            }
        }
        if(a!=-1)
        dp[p][a][b][c]=res%mod;
        return res%mod;
    }
    public int numOfWays(int n) {
        dp=new long[n+1][3][3][3];
        for(int i=1;i<=n;i++)
        for(int j=0;j<3;j++)
        for(int k=0;k<3;k++)
        for(int l=0;l<3;l++)
        dp[i][j][k][l]=-1;
        return (int)(find(1,new int[]{-1,-1,-1},n));
    }
}