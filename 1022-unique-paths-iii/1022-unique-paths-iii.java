class Solution {
    int[][] a;
    int m,n;
    int c=0;
    boolean[][] seen;
    int target=0;
    public void dfs(int i,int j,int walked){
        if(i<0||j<0||i>=m||j>=n||seen[i][j]||a[i][j]==-1)
        return;
        walked++;
        if(walked==target&&a[i][j]==2){
            c++;
            return;
        }
        seen[i][j]=true;
        dfs(i+1,j,walked);
        dfs(i-1,j,walked);
        dfs(i,j+1,walked);
        dfs(i,j-1,walked);
        seen[i][j]=false;
    }
    public int uniquePathsIII(int[][] grid) {
        a=grid;
        m=grid.length;
        n=grid[0].length;
        seen=new boolean[m][n];
        int si,sj;
        si=sj=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a[i][j]!=-1)
                target++;
                if(a[i][j]==1){
                    si=i;
                    sj=j;
                }
            }
        }
        dfs(si,sj,0);
        return c;
    }
}