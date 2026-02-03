class Solution {
    boolean[][] seen;
    int n,m;
    int[][] grid;
    public int bfs(int i,int j){
        if(i<0||j<0||i>=m||j>=n||seen[i][j]||grid[i][j]==0)
        return 0;
        seen[i][j]=true;
        int ans=grid[i][j];
        ans=ans+bfs(i+1,j);
        ans=ans+bfs(i-1,j);
        ans=ans+bfs(i,j+1);
        ans=ans+bfs(i,j-1);
        return ans;
    }
    public int countIslands(int[][] grid, int k) {
        m=grid.length;
        n=grid[0].length;
        int ans=0;
        seen=new boolean[m][n];
        this.grid=grid;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int res=bfs(i,j);
                if(res%k==0&&res!=0)
                ans++;
            }
        }
        return ans;
    }
}