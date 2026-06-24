class Solution {
    double[][] dp;
    int n;
    public double find(int i,int k,int[] a){
        if(i==n)
        return 0;
        double res=0;
        if(dp[i][k]!=-1)
        return dp[i][k];
        if(k==1){
            double s=0;
            for(int j=i;j<n;j++){
                s=s+a[j];
            }
            return s/(n-i);
        }
        double s=0;
        for(int j=i;j<n;j++){
            s=s+a[j];
            res=Math.max(res,s/(j-i+1)+find(j+1,k-1,a));
        }
        return dp[i][k]=res;
    }
    public double largestSumOfAverages(int[] nums, int k) {
        dp=new double[nums.length][k+1];
        n=nums.length;
        for(int i=0;i<n;i++)
        for(int j=0;j<=k;j++)
        dp[i][j]=-1;
        return find(0,k,nums);
    }
}