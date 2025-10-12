class Solution {
    boolean cycle=false;
    boolean[][] seen;
    int m,n;
    char[][] a;

    public boolean dfs(int i,int j,int pi,int pj,char ch){
        if(i<0||j<0||i>=m||j>=n)
            return false;
        if(a[i][j]!=ch)
            return false;
        if(seen[i][j])
            return true;
        seen[i][j]=true;
        if(!(i-1==pi&&j==pj)&&dfs(i-1,j,i,j,ch))
            return true;
        if(!(i+1==pi&&j==pj)&&dfs(i+1,j,i,j,ch))
            return true;
        if(!(i==pi&&j-1==pj)&&dfs(i,j-1,i,j,ch))
            return true;
        if(!(i==pi&&j+1==pj)&&dfs(i,j+1,i,j,ch))
            return true;

        return false;
    }

    public boolean containsCycle(char[][] grid) {
        a=grid;
        m=grid.length;
        n=grid[0].length;
        seen=new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!seen[i][j]){
                    if(dfs(i,j,-1,-1,a[i][j]))
                        return true;
                }
            }
        }
        return false;
    }
}
