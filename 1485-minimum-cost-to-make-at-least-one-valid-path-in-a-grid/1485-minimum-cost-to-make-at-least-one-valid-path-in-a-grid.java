class Solution {
    public int minCost(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dist=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0,0});
        dist[0][0]=0;
        int[][] dirs={{0,1,1},{0,-1,2},{1,0,3},{-1,0,4}};
        while(!pq.isEmpty()){
            int[] a=pq.poll();
            int w=a[0];
            int i=a[1];
            int j=a[2];
            if(i==m-1&&j==n-1) return w;
            if(w>dist[i][j]) continue;
            for(int[] d:dirs){
                int ni=i+d[0],nj=j+d[1];
                if(ni>=0&&ni<m&&nj>=0&&nj<n){
                    int newW=w+(grid[i][j]==d[2]?0:1);
                    if(newW<dist[ni][nj]){
                        dist[ni][nj]=newW;
                        pq.add(new int[]{newW,ni,nj});
                    }
                }
            }
        }
        return 0;
    }
}
