class Solution {
    int n;
    int[][] grid;
    int[][] dir={{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1}};
    public boolean dfs(int i,int j){
        if(grid[i][j]==n*n-1)
        return true;
        for(int[] a:dir){
            int ni=i+a[0];
            int nj=j+a[1];
            if(ni<0||nj<0||ni>=n||nj>=n||grid[ni][nj]!=grid[i][j]+1)
            continue;
            else{
                return dfs(ni,nj);
            }
        }
        return false;
    }
    public boolean checkValidGrid(int[][] grid) {
        this.grid=grid;
        n=grid.length;
        if(grid[0][0]!=0)
        return false;
        return dfs(0,0);
    }
}