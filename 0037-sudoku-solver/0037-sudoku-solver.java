class Solution {
    int m,n;
    boolean[][] row,col;
    boolean[][][] grid;
    boolean found=false;
    public void find(int i,int j,int left,char[][] a){
        if(found)
        return;
        if(left==0){
            found=true;
            return;
        }
        if(j>=n){
            find(i+1,0,left,a);
            return;
        }
        if(a[i][j]!='.'){
            find(i,j+1,left,a);
            return;
        }
        for(int k=1;k<=9;k++){
            if(!row[i][k]&&!col[j][k]&&!grid[i/3][j/3][k]){
                row[i][k]=true;
                col[j][k]=true;
                grid[i/3][j/3][k]=true;
                a[i][j]=(char)('0'+k);
                find(i,j+1,left-1,a);
                if(found)
        return;
                row[i][k]=false;
                col[j][k]=false;
                grid[i/3][j/3][k]=false;
                a[i][j]='.';
            }
        }
    }
    public void solveSudoku(char[][] board) {
        m=board.length;
        n=board[0].length;
        row=new boolean[m][10];
        col=new boolean[n][10];
        grid=new boolean[3][3][10];
        int left=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='.'){
                    left++;
                }
                else{
                int val=board[i][j]-'0';
                row[i][val]=true;
                col[j][val]=true;
                grid[i/3][j/3][val]=true;
                }
            }
        }
        find(0,0,left,board);
    }
}