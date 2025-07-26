class Solution {
    boolean[][] ar;
    char[][] a;
    int m,n;
    public void dfs(int i,int j){
        if(i<0||j<0||i>=m||j>=n||ar[i][j]||a[i][j]=='X')
        return;
        ar[i][j]=true;
        dfs(i+1,j);
        dfs(i-1,j);
        dfs(i,j+1);
        dfs(i,j-1);
    }
    public void solve(char[][] board) {
        a=board;
        m=board.length;
        n=board[0].length;
        ar=new boolean[m][n];
        for(int j=0;j<n;j++){
            dfs(0,j);
            dfs(m-1,j);
        }
        for(int i=0;i<m;i++){
            dfs(i,0);
            dfs(i,n-1);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!ar[i][j])
                a[i][j]='X';
            }
        }
    }
}