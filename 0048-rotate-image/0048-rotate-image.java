class Solution {
    public void rotate(int[][] matrix) { 
        int t=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix.length;j++){
                t=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=t;
            }
        }
        int l=0;
        int r=0;
        for(int i=0;i<matrix.length;i++){
            l=0;
            r=matrix.length-1;
            while(l<r){
                t=matrix[i][l];
                matrix[i][l]=matrix[i][r];
                matrix[i][r]=t;
                l++;
                r--;
            }
        }
    }
}