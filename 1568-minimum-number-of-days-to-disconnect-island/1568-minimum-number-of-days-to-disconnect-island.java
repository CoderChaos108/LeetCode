class Solution {
    boolean seen[][];
    int m,n;
    int[][] grid;
    int c=0;
    public void dfs(int i,int j){
        if(i<0||j<0||i>=m||j>=n||seen[i][j]||grid[i][j]==0)
        return;
        seen[i][j]=true;
        c++;
        dfs(i+1,j);
        dfs(i-1,j);
        dfs(i,j+1);
        dfs(i,j-1);
    }
    public int minDays(int[][] grid) {
        int islands=0;
        m=grid.length;
        n=grid[0].length;
        int ans=0;
        this.grid=grid;
        seen=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!seen[i][j]&&grid[i][j]==1){
                    if(++islands==2)
                    return 0;
                    dfs(i,j);
                }
            }
        }
        if(c==0||c==1||c==2)
        return c;
        int total=c;
        int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0)
                continue;
                grid[i][j]=0;
                c=0;
                seen=new boolean[m][n];
                for(int[] d:dir){
                    int ni=i+d[0];
                    int nj=j+d[1];
                    if(ni<0||nj<0||ni>=m||nj>=n||grid[ni][nj]==0)
                    continue;
                    dfs(ni,nj);
                    break;
                }
                if(c!=total-1)
                return 1;
                grid[i][j]=1;
            }
        }
        return 2;
    }
}