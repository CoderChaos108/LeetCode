class Solution {
    int mod=1000000007;
    int[][][] dp;
    public int find(int i,int absents,int consLates,int n){
        if(absents==2||consLates==3)
        return 0;
        if(i==n){
            return 1;
        }
        if(dp[i][absents][consLates]!=-1)
        return dp[i][absents][consLates];
        long res=0;
        int a=find(i+1,absents+1,0,n);
        int b=find(i+1,absents,consLates+1,n);
        int c=find(i+1,absents,0,n);
        res=res+a+b+c;
        res=res%mod;
        dp[i][absents][consLates]=(int)res;
        return (int)res;
    }
    public int checkRecord(int n) {
        dp=new int[n][2][3];
        for(int i=0;i<n;i++)
        for(int j=0;j<2;j++)
        for(int k=0;k<3;k++)
        dp[i][j][k]=-1;
        return find(0,0,0,n);
    }
}