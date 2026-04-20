class Solution {
    int mod=1000000007;
    int[][] dp;

    public int play(int i,int played,int n,int goal,int k){

        if(i==goal){
            if(played==n) return 1;
            return 0;
        }

        if(dp[i][played]!=-1)
        return dp[i][played];

        long res=0;

        if(played<n){
            res=res+(long)(n-played)*play(i+1,played+1,n,goal,k);
        }

        if(played>k){
            res=res+(long)(played-k)*play(i+1,played,n,goal,k);
        }

        dp[i][played]=(int)(res%mod);
        return dp[i][played];
    }

    public int numMusicPlaylists(int n,int goal,int k) {
        dp=new int[goal+1][n+1];
        for(int[] a:dp)
        Arrays.fill(a,-1);

        return play(0,0,n,goal,k);
    }
}