class Solution {
    boolean[][] seen;
    int m,n;
    char[][] a;
    int c=0;
    public void count(int i,int j){
        if(i<0||j<0||i>=m||j>=n||seen[i][j]||a[i][j]=='.')
        return;
        seen[i][j]=true;
        count(i,j-1);
        count(i,j+1);
        count(i+1,j);
        count(i-1,j);

    }
    public int countBattleships(char[][] board) {
        a=board;
        m=a.length; 
        n=a[0].length;
        seen=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a[i][j]!='.'&&!seen[i][j]){
                    c++;
                count(i,j);
                }
            }
        }
        return c;
    }
}