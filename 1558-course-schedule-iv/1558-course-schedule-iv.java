class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean[][] a=new boolean[n][n];
        for(int[] pr:prerequisites)
        a[pr[0]][pr[1]]=true;
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    //ij=ik,kj
                    a[i][j]=a[i][j]||(a[i][k]&&a[k][j]);
                }
            }
        }
        List<Boolean> ans=new ArrayList<>();
        for(int q[]:queries){
            ans.add(a[q[0]][q[1]]);
        }
        return ans;
    }
}