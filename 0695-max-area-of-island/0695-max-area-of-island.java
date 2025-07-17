class Solution {
    int m,n;
    boolean[][] seen;
    public int area(int i,int j,int[][] a){
        if(a[i][j]==0||seen[i][j])
        return 0;
        int s=1;
        seen[i][j]=true;
        if(i+1<m)
        s=s+area(i+1,j,a);
        if(i-1>=0)
        s=s+area(i-1,j,a);
        if(j+1<n)
        s=s+area(i,j+1,a);
        if(j-1>=0)
        s=s+area(i,j-1,a);
        return s;
    }
    public int maxAreaOfIsland(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        seen=new boolean[m][n];
        int area=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                area=Math.max(area,area(i,j,grid));
            }
        }
        return area;
    }
}