class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int len=matrix.length;
        int l=0;
        int r=matrix[0].length-1;
        int m;
        for(int i=0;i<len;i++){
            l=0;
            r=matrix[0].length-1;           
            while(l<=r){
            m=(l+r)/2;
            if(target<matrix[i][0]||target>matrix[i][r])
            break;
            if(matrix[i][m]==target)
            return true;
            if(matrix[i][m]<target){
                l=m+1;
            }
            if(matrix[i][m]>target)
            r=m-1;
            }
        }
        return false;
    }
}