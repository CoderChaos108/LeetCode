class Solution {
    char[][] a;
    char[][] b;
    int m,n;
    boolean[][] seen;
    public void build(int i,int j){
        set(i+1,j);
        set(i-1,j);
        set(i,j+1);
        set(i,j-1);
        set(i+1,j+1);
        set(i+1,j-1);
        set(i-1,j+1);
        set(i-1,j-1);
    }
    public void set(int i,int j){
        if(i<0||j<0||i>=m||j>=n)
        return;
        if(Character.isDigit(a[i][j])){
            a[i][j]=(char)((int)a[i][j]+1);
        }
        else
        a[i][j]='1';
    }
    public void click(int i,int j){
        if(i<0||j<0||i>=m||j>=n||seen[i][j])
        return;
        if(b[i][j]=='M')
        return;
        b[i][j]=a[i][j];
        seen[i][j]=true;
        if(Character.isDigit(b[i][j]))
        return;
        click(i+1,j);
        click(i-1,j);
        click(i,j+1);
        click(i,j-1);
        click(i+1,j+1);
        click(i+1,j-1);
        click(i-1,j+1);
        click(i-1,j-1);
    }
    public char[][] updateBoard(char[][] board, int[] click) {
        b=board;
        m=b.length;
        n=b[0].length;
        a=new char[m][n];
        seen=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(b[i][j]=='M')
                build(i,j);
                else if(!Character.isDigit(a[i][j])){
                    a[i][j]='B';
                }
            }
        }
        int r=click[0];
        int c=click[1];
        if(b[r][c]=='M'){
            b[r][c]='X';
            return b;
        }
        click(r,c);
        return b;
    }
}