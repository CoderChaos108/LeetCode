class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(r*c!=mat.length*mat[0].length)
        return mat;
        int[][] a=new int[r][c];
        int p=0;
        int q=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                a[p][q]=mat[i][j];
                if(q==c-1){
                    p++;
                    q=0;
                }
                else
                q++;
            }
        }
        return a;
    }
}