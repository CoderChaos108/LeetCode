class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid[0].length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{grid[0][0],0,0});
        boolean[][] seen=new boolean[n][n];
        while(true){
            int[] a=pq.poll();
            int t=a[0];
            int i=a[1];
            int j=a[2];
            if(seen[i][j])
            continue;
            seen[i][j]=true;
            if(i==n-1&&j==n-1)
            return t;
            if(i-1>=0){
                int newT=Math.max(grid[i-1][j],t);
                pq.add(new int[]{newT,i-1,j});
            }
            if(j-1>=0){
                int newT=Math.max(grid[i][j-1],t);
                pq.add(new int[]{newT,i,j-1});
            }
            if(i+1<n){
                int newT=Math.max(grid[i+1][j],t);
                pq.add(new int[]{newT,i+1,j});
            }
            if(j+1<n){
                int newT=Math.max(grid[i][j+1],t);
                pq.add(new int[]{newT,i,j+1});
            }
        }
    }
}