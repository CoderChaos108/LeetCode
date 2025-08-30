class Solution {
    public int minTimeToReach(int[][] moveTime) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0,0});
        int n=moveTime.length;
        int m=moveTime[0].length;
        while(true){
            int[] a=pq.poll();
            int t=a[0];
            int i=a[1];
            int j=a[2];
            if(i==n-1&&j==m-1)
            return t;
            if(i-1>=0&&moveTime[i-1][j]!=-1){
                int newT=Math.max(t+1,moveTime[i-1][j]+1);
                pq.add(new int[]{newT,i-1,j});
                 moveTime[i-1][j]=-1;
            }
            if(j-1>=0&&moveTime[i][j-1]!=-1){
                int newT=Math.max(t+1,moveTime[i][j-1]+1);
                pq.add(new int[]{newT,i,j-1});
                 moveTime[i][j-1]=-1;
            }
            if(i+1<n&&moveTime[i+1][j]!=-1){
                int newT=Math.max(t+1,moveTime[i+1][j]+1);
                pq.add(new int[]{newT,i+1,j});
                 moveTime[i+1][j]=-1;
            }
            if(j+1<m&&moveTime[i][j+1]!=-1){
                int newT=Math.max(t+1,moveTime[i][j+1]+1);
                pq.add(new int[]{newT,i,j+1});
                 moveTime[i][j+1]=-1;
            }
        }
    }
}