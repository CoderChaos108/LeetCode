class Solution {
    public int minPathSum(int[][] grid) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0,0,grid[0][0]});
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] seen=new boolean[m][n];
        while(true){
            int[] a=pq.poll();
            int i=a[0];
            int j=a[1];
            int sum=a[2];
            if(seen[i][j])
            continue;
            seen[i][j]=true;
            if(i==m-1&&j==n-1)
            return sum;
            if(i+1<m)
            pq.add(new int[]{i+1,j,sum+grid[i+1][j]});
            if(j+1<n)
            pq.add(new int[]{i,j+1,sum+grid[i][j+1]});
        }
    }
}