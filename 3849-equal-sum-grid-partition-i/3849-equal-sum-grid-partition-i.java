class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int[] row=new int[grid.length];
        int[] col=new int[grid[0].length];
        int rl=grid.length;
        int cl=grid[0].length;
        long sum=0;
        long sumrow=0;
        long sumcol=0;
        int x=0;
        for(int i=0;i<rl;i++) {
            sum=0;
            for(int j=0;j<cl;j++) {
                sum+=grid[i][j];
            }
            row[x]=(int)sum;
            sumrow+=sum;
            x++;
        }
        x=0;
        for(int i=0;i<cl;i++) {
            sum=0;
            for(int j=0;j<rl;j++) {
                sum+=grid[j][i];
            }
            col[x]=(int)sum;
            sumcol+=sum;
            x++;
        }
        sum=0;
        for(int i=0;i<rl-1;i++) {
            sum+=row[i];
            if(2*sum==sumrow) {
                return true;
            }
        }
        sum=0;
        for(int i=0;i<cl-1;i++) {
            sum+=col[i];
            if(2*sum==sumcol) {
                return true;
            }
        }
        return false;
    }
}