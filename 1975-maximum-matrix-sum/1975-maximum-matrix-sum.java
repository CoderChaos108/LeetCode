class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long ans=0;
        int negs=0;;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]<0)
                negs++;
                min=Math.min(min,Math.abs(matrix[i][j]));
                ans=ans+Math.abs(matrix[i][j]);
            }
        }
            if(negs%2!=0)
            ans=ans-2*min;
            return ans;
    }
}