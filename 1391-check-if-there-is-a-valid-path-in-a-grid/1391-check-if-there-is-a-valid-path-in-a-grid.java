class Solution {
    int m,n;
    HashMap<Integer, int[][]> directions = new HashMap<>();
    HashMap<Integer, int[][]> valid = new HashMap<>();
    boolean[][] seen;
    public Solution() {
        directions.put(1, new int[][]{{0, -1}, {0, 1}});
        directions.put(2, new int[][]{{1, 0}, {-1, 0}});
        directions.put(3, new int[][]{{0, -1}, {1, 0}});
        directions.put(4, new int[][]{{0, 1}, {1, 0}});
        directions.put(5, new int[][]{{0, -1}, {-1, 0}});
        directions.put(6, new int[][]{{0, 1}, {-1, 0}});

        valid.put(1, new int[][]{{1, 4, 6}, {1, 3, 5}});
        valid.put(2, new int[][]{{2, 5, 6}, {2, 3, 4}});
        valid.put(3, new int[][]{{1, 4, 6}, {2, 5, 6}});
        valid.put(4, new int[][]{{1, 3, 5}, {2, 5, 6}});
        valid.put(5, new int[][]{{1, 4, 6}, {2, 3, 4}});
        valid.put(6, new int[][]{{1, 3, 5}, {2, 3, 4}});
    }
    public boolean dfs(int i,int j,int[][] a){
        if(i<0||j<0||i>=m||j>=n)
        return false;
        if(i==m-1&&j==n-1)
        return true;
        if(seen[i][j])
        return false;
        seen[i][j]=true;
        int curr=a[i][j];
        int p=0;
        for(int[] d:directions.get(curr)){
            int ni=i+d[0];
            boolean found=false;
            int nj=j+d[1];
            if(ni>=0&&nj>=0&&ni<m&&nj<n){
                int next=a[ni][nj];
                int[] v=valid.get(curr)[p];
                for(int poss:v){
                    if(poss==next){
                        found=true;
                        break;
                    }
                }
                if(found){
                    if(dfs(ni,nj,a))
                    return true;
                }
            }
            p++;
        }
        return false;
    }
    public boolean hasValidPath(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        seen=new boolean[m][n];
        return dfs(0,0,grid);
    }
}