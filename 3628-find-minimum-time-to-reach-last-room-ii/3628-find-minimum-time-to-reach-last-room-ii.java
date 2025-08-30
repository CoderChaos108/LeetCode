class Solution {
    public int minTimeToReach(int[][] moveTime) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0,0,1});
        int m=moveTime.length;
        int n=moveTime[0].length;
        while(true){
            int[] a=pq.poll();
            int t=a[0];
            int i=a[1];
            int j=a[2];
            if(i==m-1&&j==n-1)
            return t;
            int factor=a[3];
            if(i-1>=0&&moveTime[i-1][j]!=-1){
                int newFactor;
                int newT=Math.max(t+factor,moveTime[i-1][j]+factor);
                if(factor==1)
                newFactor=2;
                else
                newFactor=1;
                pq.add(new int[]{newT,i-1,j,newFactor});
                moveTime[i-1][j]=-1;
            }
            if(j-1>=0&&moveTime[i][j-1]!=-1){
                int newFactor;
                int newT=Math.max(t+factor,moveTime[i][j-1]+factor);
                if(factor==1)
                newFactor=2;
                else
                newFactor=1;
                pq.add(new int[]{newT,i,j-1,newFactor});
                moveTime[i][j-1]=-1;
            }
            if(i+1<m&&moveTime[i+1][j]!=-1){
                int newT=Math.max(t+factor,moveTime[i+1][j]+factor);
                int newFactor;
                if(factor==1)
                newFactor=2;
                else
                newFactor=1;
                pq.add(new int[]{newT,i+1,j,newFactor});
                moveTime[i+1][j]=-1;
            }
            if(j+1<n&&moveTime[i][j+1]!=-1){
                int newFactor;
                int newT=Math.max(t+factor,moveTime[i][j+1]+factor);
                if(factor==1)
                newFactor=2;
                else
                newFactor=1;
                pq.add(new int[]{newT,i,j+1,newFactor});
                moveTime[i][j+1]=-1;
            }
        }
    }
}