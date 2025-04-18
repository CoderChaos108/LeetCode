class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int u=0;
        int d=matrix.length-1;
        if(matrix.length==1){
            for(int i=0;i<matrix[0].length;i++){
                if(matrix[0][i]==target)
                return true;
                if(i==matrix[0].length-1)
                return false;
            }
        }
        while(u<=d){
            if(matrix[u][0]<=target&&matrix[u+1][0]>target)
            break;
            if(d==matrix.length-1){
                if(target>=matrix[d][0]){
                u=d;
                break;
                }
            }
            else{
                if(target>=matrix[d][0]&&target<matrix[d+1][0]){
                    u=d;
                    break;
                }
                
            }
            u++;
            d--;
        }
        if(u>d)
        return false;
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[u][i]==target)
            return true;
        }
        return false;
    }
}