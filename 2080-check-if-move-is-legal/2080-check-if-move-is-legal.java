class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        int[][] dir=new int[][]{
            {-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}
        };
        board[rMove][cMove]=color;
        for(int[] a:dir){
            int ni=a[0];
            int nj=a[1];
            int i=rMove;
            int j=cMove;
            boolean oppFound=false;
            boolean first=true;
            while(i>=0&&j>=0&&i<8&&j<8){
                char c=board[i][j];
                if(c=='.')
                break;
                if(c==color){
                    if(oppFound)
                    return true;
                    if(!first)
                    break;
                    first=false;
                }
                else
                oppFound=true;
                i=i+ni;
                j=j+nj;
            }
        }
        return false;
    }
}