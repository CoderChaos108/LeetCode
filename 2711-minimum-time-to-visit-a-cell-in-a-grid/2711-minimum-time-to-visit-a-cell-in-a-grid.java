class Solution {
    public int minimumTime(int[][] grid) {
        if(grid[0][1]>1&&grid[1][0]>1)
        return -1;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[2]-b[2]));
        pq.add(new int[]{0,0,0});
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] seen=new boolean[m][n];
        while(true){
            int[] a=pq.poll();
            int i=a[0];
            int j=a[1];
            int time=a[2];
            if(seen[i][j])
            continue;
            seen[i][j]=true;
            if(i==m-1&&j==n-1)
            return time;
            if(i-1>=0){
                int newTime=0;
                int minTime=grid[i-1][j];
                if(minTime<=time+1)
                newTime=time+1;
                else{
                    if((minTime-time)%2!=0)
                    newTime=minTime;
                    else
                    newTime=minTime+1;
                }
                pq.add(new int[]{i-1,j,newTime});
            }
            if(j-1>=0){
                int newTime=0;
                int minTime=grid[i][j-1];
                if(minTime<=time+1)
                newTime=time+1;
                else{
                    if((minTime-time)%2!=0)
                    newTime=minTime;
                    else
                    newTime=minTime+1;
                }
                pq.add(new int[]{i,j-1,newTime});
            }
            if(i+1<m){
                int newTime=0;
                int minTime=grid[i+1][j];
                if(minTime<=time+1)
                newTime=time+1;
                else{
                    if((minTime-time)%2!=0)
                    newTime=minTime;
                    else
                    newTime=minTime+1;
                }
                pq.add(new int[]{i+1,j,newTime});
            }
            if(j+1<n){
                int newTime=0;
                int minTime=grid[i][j+1];
                if(minTime<=time+1)
                newTime=time+1;
                else{
                    if((minTime-time)%2!=0)
                    newTime=minTime;
                    else
                    newTime=minTime+1;
                }
                pq.add(new int[]{i,j+1,newTime});
            }
        }
    }
}