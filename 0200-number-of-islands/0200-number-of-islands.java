class Solution {
    HashSet<List<Integer>> seen;
    int m,n;
    public void check(int i,int j,char[][] a){
        if(a[i][j]=='0'||seen.contains(Arrays.asList(i,j)))
        return;
        seen.add(Arrays.asList(i,j));
        if(i+1<m)
        check(i+1,j,a);
        if(i-1>=0)
        check(i-1,j,a);
        if(j+1<n)
        check(i,j+1,a);
        if(j-1>=0)
        check(i,j-1,a);
    }
    public int numIslands(char[][] grid) {
         m=grid.length;
        seen=new HashSet<>();
        n=grid[0].length;
        int c=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'&&!seen.contains(Arrays.asList(i,j))){
                c++;
                check(i,j,grid);
                }
            }
        }
        return c;
    }
}