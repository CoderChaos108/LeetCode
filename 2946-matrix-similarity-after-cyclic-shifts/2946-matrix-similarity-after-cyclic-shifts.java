class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int[][] a;
        int m=mat.length;
        int n=mat[0].length;
        k=k%n;
        a=new int[m][n];
        for(int i=0;i<m;i++){
            if(i%2==0){
                for(int j=0;j<n;j++){
                    int nj=(j+k)%n;
                    a[i][nj]=mat[i][j];
                }
            }
            else{
                for(int j=0;j<n;j++){
                    int nj=j-k;
                    if(nj<0){
                        nj=n+nj;
                    }
                    a[i][nj]=mat[i][j];
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a[i][j]!=mat[i][j])
                return false;
            }
        }
        return true;
    }
}