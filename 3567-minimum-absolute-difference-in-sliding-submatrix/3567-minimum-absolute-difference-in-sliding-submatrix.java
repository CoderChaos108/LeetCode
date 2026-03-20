class Solution {
    int m,n;
    public int enumerate (int x,int y,int k,int[][] grid){
        HashSet<Integer> set=new HashSet<>();
        for(int i=x;i<x+k;i++){
            for(int j=y;j<y+k;j++){
                set.add(grid[i][j]);
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i:set){
            for(int j:set){
                if(i!=j)
                ans=Math.min(Math.abs(i-j),ans);
            }
        }
        if(ans==Integer.MAX_VALUE)
        return 0;
        return ans;
    }
    public int[][] minAbsDiff(int[][] grid, int k) {
        m=grid.length;
        n=grid[0].length;
        int[][] matrix=new int[m-k+1][n-k+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i+k-1>=m||j+k-1>=n)
                continue;
                matrix[i][j]=enumerate(i,j,k,grid);
            }
        }
        return matrix;
    }
}