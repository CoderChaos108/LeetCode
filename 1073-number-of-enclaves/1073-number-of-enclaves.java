class Solution {
    boolean[][] ar;
    int m,n;
    int[][] a;
    public void dfs(int i,int j){
        if(i<0||j<0||i>=m||j>=n||a[i][j]==0||ar[i][j])
        return;
        ar[i][j]=true;
        dfs(i+1,j);
        dfs(i-1,j);
        dfs(i,j+1);
        dfs(i,j-1);
    }
    public int numEnclaves(int[][] grid) {
        a=grid;
        m=a.length;
        n=a[0].length;
        ar=new boolean[m][n];
        for(int i=0;i<m;i++){
            dfs(i,0);
            dfs(i,n-1);
        }
        for(int j=0;j<n;j++){
            dfs(0,j);
            dfs(m-1,j);
        }
        int c=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!ar[i][j]&&a[i][j]==1)
                c++;
            }
        }
        return c;
    }
}