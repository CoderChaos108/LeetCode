class Solution {
    int m;
    int n;
    int[] row,col;
    int[][] a;
    public int countServers(int[][] grid) {
        a=grid;
        m=a.length;
        n=a[0].length;
        row= new int[m];
        col= new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                row[i]++;
                col[j]++;
                }
            }
        }
        int ans=0;
       for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1&&(row[i]>1||col[j]>1)){
                    ans++;
                }
            }
        }
        return ans;
    }
}