class Solution {
    boolean[][] atlantic,pacific;
    int m,n;
    int[][] a;
    List<List<Integer>> ans;
    public void dfs_p(int i,int j){
        if(pacific[i][j])
        return;
        pacific[i][j]=true;
        if(atlantic[i][j]==true)
        ans.add(Arrays.asList(i,j));
        if(i+1<m&&a[i+1][j]>=a[i][j])
        dfs_p(i+1,j);
        if(i-1>=0&&a[i-1][j]>=a[i][j])
        dfs_p(i-1,j);
        if(j+1<n&&a[i][j+1]>=a[i][j])
        dfs_p(i,j+1);
        if(j-1>=0&&a[i][j-1]>=a[i][j])
        dfs_p(i,j-1);
    }
    public void dfs_a(int i,int j){
        if(atlantic[i][j])
        return;
        atlantic[i][j]=true;
        if(pacific[i][j]==true)
        ans.add(Arrays.asList(i,j));
        if(i+1<m&&a[i+1][j]>=a[i][j])
        dfs_a(i+1,j);
        if(i-1>=0&&a[i-1][j]>=a[i][j])
        dfs_a(i-1,j);
        if(j+1<n&&a[i][j+1]>=a[i][j])
        dfs_a(i,j+1);
        if(j-1>=0&&a[i][j-1]>=a[i][j])
        dfs_a(i,j-1);
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ans=new ArrayList<>();
        a=heights;
        m=a.length;
        n=a[0].length;
        atlantic=new boolean[m][n];
        pacific=new boolean[m][n];
        for(int j=0;j<n;j++)
        dfs_p(0,j);
        for(int i=0;i<m;i++)
        dfs_p(i,0);
        for(int j=0;j<n;j++)
        dfs_a(m-1,j);
        for(int i=0;i<m;i++)
        dfs_a(i,n-1);
        return ans;
    }
}