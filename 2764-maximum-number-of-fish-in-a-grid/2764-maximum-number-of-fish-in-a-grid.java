class Solution {
    int m,n;
    int[][] a;
    public int dfs(int i,int j){
        if(i<0||j<0||i==m||j==n||a[i][j]==0)
        return 0;
        int caught=a[i][j];
        a[i][j]=0;
        caught=caught+dfs(i+1,j);
        caught=caught+dfs(i-1,j);
        caught=caught+dfs(i,j-1);
        caught=caught+dfs(i,j+1);
        return caught;
    }
    public int findMaxFish(int[][] grid) {
        a=grid;
        m=a.length;
        n=a[0].length;
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a[i][j]!=0)
                ans=Math.max(ans,dfs(i,j));
            }
        }
        return ans;
    }
}