class Solution {

    int[][][] dp;

    int dfs(int x,int y,int state){
        if(x==0 && y==0)
        return 0;

        if(dp[x][y][state]!=0)
            return dp[x][y][state];

        int ans=0;

        
        if(x>0 && state!=0){
            ans=Math.max(ans,2+dfs(x-1,y,0));
        }

        
        if(y>0 && state!=1){
            ans=Math.max(ans,2+dfs(x,y-1,1));
        }

        return dp[x][y][state]=ans;
    }

    public int longestString(int x,int y,int z) {

        int base=2*z;

        dp=new int[x+1][y+1][3];
        

        int best=dfs(x,y,2);

        return base+best;
    }
}