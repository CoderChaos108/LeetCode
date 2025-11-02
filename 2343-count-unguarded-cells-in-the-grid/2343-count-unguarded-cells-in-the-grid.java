class Solution {
    int [][] a;
    int m,n;
    int[][] guards,walls;
    public void find(int r,int c){
        for(int i=r+1;i<m;i++){
            if(a[i][c]==2)
            break;
            a[i][c]=1;
        }
        for(int j=c+1;j<n;j++){
            if(a[r][j]==2)
            break;
            a[r][j]=1;
        }
        for(int i=r-1;i>=0;i--){
            if(a[i][c]==2)
            break;
            a[i][c]=1;
        }
        for(int j=c-1;j>=0;j--){
            if(a[r][j]==2)
            break;
            a[r][j]=1;
        }
    }
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        a=new int[m][n];
        this.m=m;
        this.n=n;
        this.guards=guards;
        this.walls=walls;
        for(int[] g:guards){
            a[g[0]][g[1]]=2;
        }
        for(int[] w:walls){
            a[w[0]][w[1]]=2;
        }
        for(int[] g:guards){
            find(g[0],g[1]);
        }
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a[i][j]==0)
                ans++;
            }
        }
        return ans;
    }
}