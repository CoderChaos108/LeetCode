class Solution {
    public int countArea(int i,int j,int[][] map,int island,int n,int[][] grid){
            if(i>=n||j>=n||i<0||j<0||map[i][j]!=-1||grid[i][j]==0)
            return 0;
            map[i][j]=island;
            int c=0;
            c=c+countArea(i+1,j,map,island,n,grid);
            c=c+countArea(i,j-1,map,island,n,grid);
            c=c+countArea(i,j+1,map,island,n,grid);
            c=c+countArea(i-1,j,map,island,n,grid);
            return 1+c;
    }
    public int largestIsland(int[][] grid) {
        int ans=0;
        int n=grid.length;
        List<Integer> islands=new ArrayList<>();
        int[][] map=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map[i][j]=-1;       
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0||map[i][j]!=-1)
                continue;
                int island=islands.size();
                int area=countArea(i,j,map,island,n,grid);
                islands.add(area);
                ans=Math.max(ans,area);
            }
        }
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    HashSet<Integer> set=new HashSet<>();
                    int area=1;
                    for(int[] dir:dirs){
                        int ni=i+dir[0];
                        int nj=j+dir[1];
                        if(ni>=n||nj>=n||ni<0||nj<0||grid[ni][nj]==0)
                        continue;
                        int island=map[ni][nj];
                        if(set.add(island)){
                            area=area+islands.get(island);
                        }
                    }
                    ans=Math.max(ans,area);
                }
            }
        }
        return ans;
    }
}