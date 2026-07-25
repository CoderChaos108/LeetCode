class Solution {
    int mod=(int)(1e9)+7;
    int[][][] dp;
    int min;
    int n;
    public int find(int i,int p,int k,int[] group,int[] profit){
        p=Math.min(p,min);
        k=Math.min(n,k);
        if(i==group.length){
            if(p>=min&&k<n)
            return 1;
            return 0;
        }
        if(dp[i][p][k]!=-1)
        return dp[i][p][k];
        long take=find(i+1,p+profit[i],k+group[i],group,profit);
        take=take%mod;
        long skip=find(i+1,p,k,group,profit);
        skip=skip%mod;
        long res=(take+skip)%mod;
        return dp[i][p][k]=(int)res;
    }
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        HashMap<Integer,List<Integer>> hm=new HashMap<>();
        min=minProfit;
        n++;
        this.n=n;
        dp=new int[group.length][minProfit+1][n+1];
        for(int i=0;i<group.length;i++)
        for(int j=0;j<minProfit+1;j++)
        for(int k=0;k<n+1;k++)
        dp[i][j][k]=-1;
        return find(0,0,0,group,profit);
    }
}