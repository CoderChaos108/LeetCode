class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n=grid.length;
        int[] row,col;
        row=new int[n];
        col=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                col[i]=Math.max(col[i],grid[j][i]);
            }            
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                row[i]=Math.max(row[i],grid[i][j]);
            }            
        }
        int sum=0;
        boolean same=false;
        while(!same){
            same=true;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    int min=Math.min(row[i],col[j]);
                    if(grid[i][j]<min){
                        sum=sum+min-grid[i][j];
                        grid[i][j]=min;
                        same=false;
                    }
                }
            }
        }
        return sum;
    }
}