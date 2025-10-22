class Solution {
    int[][] ans;
    int[][] a;
    int m,n,color;
    boolean[][] seen;
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public void dfs(int i,int j){
        if(seen[i][j])
        return;
        seen[i][j]=true;
        for(int[] d:dir){
            int ni=d[0]+i;
            int nj=d[1]+j;
            if(ni<0||nj<0||ni>=m||nj>=n||a[i][j]!=a[ni][nj])
            ans[i][j]=color;
            else
            dfs(ni,nj);
        }
    }
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        a=grid;
        this.color=color;
        m=a.length;
        n=a[0].length;
        ans=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans[i][j]=a[i][j];
            }
        }
        seen=new boolean[m][n];
        dfs(row,col);
        return ans;
    }
}