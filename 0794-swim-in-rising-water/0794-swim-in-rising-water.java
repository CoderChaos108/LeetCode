class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int max=-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                max=Math.max(max,grid[i][j]);
            }
        }
        int min=Math.max(grid[0][0],grid[n-1][n-1]);
        
        while(min<max){
            int m=(min+max)/2;
            if(canReach(grid,m,n)){
                max=m;
            }else{
                min=m+1;
            }
        }
        return min;
    }
    
    private boolean canReach(int[][] grid,int m,int n){
        Queue<int[]> q=new LinkedList<>();
        boolean[][] seen=new boolean[n][n];
        q.add(new int[]{0,0});
        seen[0][0]=true;
        
        while(!q.isEmpty()){
            int[] a=q.poll();
            int i=a[0];
            int j=a[1];
            if(i==n-1&&j==n-1){
                return true;
            }
            if(grid[i][j]>m) continue;
            if(i-1>=0&&!seen[i-1][j]){
                seen[i-1][j]=true;
                q.add(new int[]{i-1,j});
            }
            if(i+1<n&&!seen[i+1][j]){
                seen[i+1][j]=true;
                q.add(new int[]{i+1,j});
            }
            if(j-1>=0&&!seen[i][j-1]){
                seen[i][j-1]=true;
                q.add(new int[]{i,j-1});
            }
            if(j+1<n&&!seen[i][j+1]){
                seen[i][j+1]=true;
                q.add(new int[]{i,j+1});
            }
        }
        return false;
    }
}
