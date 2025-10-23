class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[] rows=new int[m];
        int[] cols=new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0)
                rows[i]--;
                else
                rows[i]++;
            }
        }
        for(int j=0;j<n;j++){
            for(int i=0;i<m;i++){
                if(grid[i][j]==0)
                cols[j]--;
                else
                cols[j]++;
            }
        }
        int[][] diff=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                diff[i][j]=rows[i]+cols[j];
            }
        }
        return diff;
    }
}