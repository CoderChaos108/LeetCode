class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0,0});
        int m=heights.length;
        int n=heights[0].length;
        boolean[][] seen=new boolean[m][n];
        while(!pq.isEmpty()){
            int[] a=pq.poll();
            int eff=a[0];
            int i=a[1];
            int j=a[2];
            if(seen[i][j]) continue;
            seen[i][j]=true;
            if(i==m-1&&j==n-1)
                return eff;
            int val=heights[i][j];
            if(i-1>=0&&!seen[i-1][j]){
                int newEff=Math.max(eff,Math.abs(val-heights[i-1][j]));
                pq.add(new int[]{newEff,i-1,j});
            }
            if(i+1<m&&!seen[i+1][j]){
                int newEff=Math.max(eff,Math.abs(val-heights[i+1][j]));
                pq.add(new int[]{newEff,i+1,j});
            }
            if(j-1>=0&&!seen[i][j-1]){
                int newEff=Math.max(eff,Math.abs(val-heights[i][j-1]));
                pq.add(new int[]{newEff,i,j-1});
            }
            if(j+1<n&&!seen[i][j+1]){
                int newEff=Math.max(eff,Math.abs(val-heights[i][j+1]));
                pq.add(new int[]{newEff,i,j+1});
            }
        }
        return 0;
    }
}
