class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] a=new int[n][n];
        for(int[] q:queries){
            int i1=q[0];
            int j1=q[1];
            int i2=q[2];
            int j2=q[3];
            for(int i=i1;i<=i2;i++){
                for(int j=j1;j<=j2;j++){
                    a[i][j]++;
                }
            }
        }
        return a;
    }
}