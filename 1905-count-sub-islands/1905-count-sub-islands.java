class Solution {
    boolean[][] seen;
    int m,n;
    int[][] grid1,grid2;
    int[][] dirs=new int[][]{
        {0,1},{0,-1},{1,0},{-1,0}
    };
    public boolean dfs(int i,int j){
        if(grid1[i][j]!=1)
        return false;
        seen[i][j]=true;
        for(int[] dir:dirs){
            int ni=i+dir[0];
            int nj=j+dir[1];
            if(ni<0||nj<0||ni>=m||nj>=n||grid2[ni][nj]==0||seen[ni][nj])
            continue;
            if(!dfs(ni,nj))
            return false;
        }
        return true;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        this.grid1=grid1;
        m=grid1.length;
        n=grid2[0].length;
        this.grid2=grid2;
        seen=new boolean[m][n];
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid2[i][j]==1&&!seen[i][j]){
                    if(dfs(i,j))
                    ans++;
                }
            }
        }
        return ans;
    }
}