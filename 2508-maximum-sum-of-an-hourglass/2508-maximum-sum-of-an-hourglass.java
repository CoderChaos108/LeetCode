class Solution {
    int ans=0;
    int[][] grid;
    int m,n;
    int[][] dir={{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
    public void sum(int i,int j){
        int s=grid[i][j];
        for(int[] a:dir){
            int ni=i+a[0];
            int nj=j+a[1];
            if(ni<0||nj<0||ni>=m||nj>=n)
            return;
            s=s+grid[ni][nj];
        }
        ans=Math.max(s,ans);
    }
    public int maxSum(int[][] grid) {
        this.grid=grid;
        m=grid.length;
        n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                sum(i,j);
            }
        }
        return ans;
    }
}