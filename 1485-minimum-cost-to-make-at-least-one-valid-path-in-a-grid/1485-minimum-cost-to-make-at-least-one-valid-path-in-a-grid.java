class Solution {
    public int minCost(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[] a=pq.poll();
            int w=a[0];
            int i=a[1];
            int j=a[2];
            if(i==m-1&&j==n-1)
            return w;
            if(j+1<n&&grid[i][j]!=-1){
                int newW=w;
                if(grid[i][j]!=1)
                newW=w+1;
                pq.add(new int[]{newW,i,j+1});
            }
            if(j-1>=0&&grid[i][j]!=-1){
                int newW=w;
                if(grid[i][j]!=2)
                newW=w+1;
                pq.add(new int[]{newW,i,j-1});
            }
            if(i+1<m&&grid[i][j]!=-1){
                int newW=w;
                if(grid[i][j]!=3)
                newW=w+1;
                pq.add(new int[]{newW,i+1,j});
            }
            if(i-1>=0&&grid[i][j]!=-1){
                int newW=w;
                if(grid[i][j]!=4)
                newW=w+1;
                pq.add(new int[]{newW,i-1,j});
            }
            grid[i][j]=-1;
        }
        return 0;
    }
}