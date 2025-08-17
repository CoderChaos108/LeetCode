class Solution {
    public int minimumObstacles(int[][] grid) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0,0});
        int m=grid.length;
        int n=grid[0].length;
        int[][] dis=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dis[i][j]=Integer.MAX_VALUE;
            }
        }
        dis[0][0]=0;
        while(!pq.isEmpty()){
            int[] a=pq.poll();
            int i=a[1];
            int j=a[2];
            int val=a[0];
            if(i==m-1&&j==n-1)
            return val;
            if(i-1>=0){
                int newVal=val;
                if(grid[i-1][j]==1)
                newVal=val+1;
                if(dis[i-1][j]>newVal){
                    dis[i-1][j]=newVal;
                    pq.add(new int[]{newVal,i-1,j});
                }
            }
            if(i+1<m){
                int newVal=val;
                if(grid[i+1][j]==1)
                newVal=val+1;
                if(dis[i+1][j]>newVal){
                    dis[i+1][j]=newVal;
                    pq.add(new int[]{newVal,i+1,j});
                }
            }
            if(j-1>=0){
                int newVal=val;
                if(grid[i][j-1]==1)
                newVal=val+1;
                if(dis[i][j-1]>newVal){
                    dis[i][j-1]=newVal;
                    pq.add(new int[]{newVal,i,j-1});
                }
            }
            if(j+1<n){
                int newVal=val;
                if(grid[i][j+1]==1)
                newVal=val+1;
                if(dis[i][j+1]>newVal){
                    dis[i][j+1]=newVal;
                    pq.add(new int[]{newVal,i,j+1});
                }
            }
        }
        return 0;
    }
}