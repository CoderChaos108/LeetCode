class Solution {
    boolean[][] seen;
    int m,n;
    int[][] a;
    int ans=0;
    public void dfs(int i,int j,int coins){
        if(i<0||j<0||i>=m||j>=n||seen[i][j]||a[i][j]==0){
            ans=Math.max(ans,coins);
            return;
        }
        coins=coins+a[i][j];
        seen[i][j]=true;
        dfs(i+1,j,coins);
        dfs(i-1,j,coins);
        dfs(i,j+1,coins);
        dfs(i,j-1,coins);
        seen[i][j]=false;
        coins=coins-a[i][j];
    }
    public int getMaximumGold(int[][] grid) {
        a=grid;
        m=a.length;
        n=a[0].length;
        seen=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a[i][j]!=0)
                dfs(i,j,0);
            }
        }
        return ans;
    }
}