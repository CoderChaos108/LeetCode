class Solution {
    int[][] dp;
    int n;
    int[] dir={-1,0,1};
    public boolean jump(int i,int k,int[] stones){
        long p=stones[i];
        boolean res=false;
        if(i==n-1)
        return true;
        if(p>=stones[n-1])
        return false;
        if(dp[i][k]!=0)
        return dp[i][k]==1;
        for(int d:dir){
            int nk=k+d;
            if(nk<=0)
            continue;
            long pos=stones[i];
            pos=pos+nk;
            int l=0;
            int r=stones.length-1;
            int m;
            int j=-1;
            while(l<=r){
                m=(l+r)/2;
                if(stones[m]==pos){
                    j=m;
                    break;
                }
                if(pos<stones[m]){
                    r=m-1;
                }
                else
                l=m+1;
            }
            if(j!=-1){
            res=res||jump(j,nk,stones);
            }
        }
        if(res)
         dp[i][k]=1;
         else
         dp[i][k]=-1;
         return dp[i][k]==1;
    }
    public boolean canCross(int[] stones) {
        n=stones.length;
        dp=new int[n][n];
        return jump(0,0,stones);
    }
}