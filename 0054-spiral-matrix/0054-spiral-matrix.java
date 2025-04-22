class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> a=new ArrayList<Integer>();
        if(matrix.length==1&&matrix[0].length==1){
            a.add(matrix[0][0]);
            return a;
        }
        int test=101;
        int l=0;
        int r=matrix[0].length-1;
        int u=0;
        int b=matrix.length-1;
        while(l!=10){
            for(int i=l;i<=r;i++){
                if(matrix[u][i]==-101)
                return a;
                a.add(matrix[u][i]);
                matrix[u][i]=-101;
            }
            for(int i=u+1;i<=b;i++){
                if(matrix[i][r]==-101)
                return a;
                a.add(matrix[i][r]);
                matrix[i][r]=-101;
            }
            for(int i=r-1;i>=l;i--){
                if(matrix[b][i]==-101)
                return a;
                a.add(matrix[b][i]);
                matrix[b][i]=-101;
            }
            for(int i=b-1;i>=u+1;i--){

                if(matrix[i][l]==-101){
                   
                return a;
                }
                a.add(matrix[i][l]);
                matrix[i][l]=-101;
            }
            l++;
            u++;
            r--;
            b--;
        }
        return a;
    }
}   
    