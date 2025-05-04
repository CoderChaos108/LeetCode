class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int[] ans=new int[mat.length*mat[0].length];
        int i=0;
        int j=0;
        int x=0;
        boolean up=true;
        while(x!=mat.length*mat[0].length-1){
            if(up){
                while(i>=0&&j<mat[0].length){
                    ans[x]=mat[i][j];
                    x++;
                    i--;
                    j++;
                }
                if(j>=mat[0].length){
                    i=i+2;
                    j=mat[0].length-1;
                }
                else if(i<0){
                    i=0;
                }
                up=false;
            }
            else{
                while(i<mat.length&&j>=0){
                    ans[x]=mat[i][j];
                    x++;
                    i++;
                    j--;
                }
                if(i>=mat.length){
                    j=j+2;
                    i=mat.length-1;
                }
                else if(j<0){
                    j=0;
                }
                up=true;
            }
        }
        ans[x]=mat[mat.length-1][mat[0].length-1];
        return ans;
    }
}
