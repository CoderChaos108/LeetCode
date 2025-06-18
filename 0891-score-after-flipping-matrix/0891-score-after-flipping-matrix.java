class Solution {
    public static void flipRow(int[][] a,int row){
            for(int i=0;i<a[0].length;i++){
                a[row][i]=a[row][i]^1;
            }
        }
        public static void flipCol(int[][] a,int row){
            for(int i=0;i<a.length;i++){
                a[i][row]=a[i][row]^1;
            }
        }
    public int matrixScore(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            if(grid[i][0]==0)
            flipRow(grid,i);
        }
        for(int i=0;i<grid[0].length;i++){
            int sum=0;
            for(int j=0;j<grid.length;j++){
                sum=sum+grid[j][i];
            }
            if(sum<(grid.length+1)/2)
            flipCol(grid,i);
        }
        int n=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<grid.length;i++){
            sb.setLength(0);
            for(int j=0;j<grid[0].length;j++){
                sb.append(String.valueOf(grid[i][j]));
            }
            n=n+Integer.parseInt(sb.toString(),2);
        }
        return n;
    }
}