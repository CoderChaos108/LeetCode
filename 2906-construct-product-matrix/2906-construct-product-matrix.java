class Solution {
    int mod=12345;
    public int[][] constructProductMatrix(int[][] grid) {
        
        int m=grid.length;
        int n=grid[0].length;
        int[][] matrix=new int[m][n];
        long[][] pre=new long[m][n];
        long[][] post=new long[m][n];
        long p=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                pre[i][j]=p;
                p=p*grid[i][j];
                p=p%mod;
            }
        }
        p=1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                post[i][j]=p;
                p=p*grid[i][j];
                p=p%mod;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                long res=pre[i][j]*post[i][j];
                res=res%12345;
                matrix[i][j]=(int)res;
            }
        }
        return matrix;
    }
}