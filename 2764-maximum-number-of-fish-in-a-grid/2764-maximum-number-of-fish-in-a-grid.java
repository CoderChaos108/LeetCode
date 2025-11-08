class Solution {
    int m,n;
    int[][] a;
    boolean[][] seen;
    public int dfs(int i,int j){
        if(i<0||j<0||i==m||j==n||a[i][j]==0||seen[i][j])
        return 0;
        seen[i][j]=true;
        int caught=a[i][j];
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
        seen=new boolean[m][n];
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!seen[i][j])
                ans=Math.max(ans,dfs(i,j));
            }
        }
        return ans;
    }
}