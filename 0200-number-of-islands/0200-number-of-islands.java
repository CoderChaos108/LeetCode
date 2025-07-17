class Solution {
    boolean[][] seen;
    int m,n;
    public void check(int i,int j,char[][] a){
        if(a[i][j]=='0'||seen[i][j])
        return;
        seen[i][j]=true;
        if(i+1<m)
        check(i+1,j,a);
        if(i-1>=0)
        check(i-1,j,a);
        if(j+1<n)
        check(i,j+1,a);
        if(j-1>=0)
        check(i,j-1,a);
    }
    public int numIslands(char[][] grid) {
         m=grid.length;
         n=grid[0].length;
        seen=new boolean[m][n];
        int c=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'&&!seen[i][j]){
                c++;
                check(i,j,grid);
                }
            }
        }
        return c;
    }
}