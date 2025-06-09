class Solution {
    public int[][] transpose(int[][] matrix) {
        int[][] mat=new int[matrix[0].length][matrix.length];
        int r=matrix.length;
        int c=matrix[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                mat[j][i]=matrix[i][j];         
            }
        }
        return mat;
    }
}