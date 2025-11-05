class Solution {
    int m,n;
    int[][] a;
    public void dfs(int i,int j){
        if(i<0||j<0||i>=m||j>=n||a[i][j]!=1)
        return;
        a[i][j]=2;
        dfs(i+1,j);
        dfs(i,j+1);
        dfs(i,j-1);
        dfs(i-1,j);
    }
    int ans=Integer.MAX_VALUE;
    public void bfs(int r,int c){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{r,c,0});
        int[][] w=new int[m][n];
        for(int i1=0;i1<m;i1++){
            for(int j1=0;j1<n;j1++){
                w[i1][j1]=Integer.MAX_VALUE;
            }
        }
        while(!q.isEmpty()){
            int size=q.size();
            for(int k=0;k<size;k++){
                int[] arr=q.poll();
                int i=arr[0];
                int j=arr[1];
                int steps=arr[2];
                if(w[i][j]<=steps)
                continue;
                w[i][j]=steps;
                if(a[i][j]==1){
                    ans=Math.min(ans,steps-1);
                    continue;
                }
                if(i-1>=0){
                    int minSteps=w[i-1][j];
                    int currSteps=steps+1;
                    if(a[i-1][j]==2)
                    currSteps=0;
                    if(currSteps<minSteps)
                    q.add(new int[]{i-1,j,currSteps});
                }
                if(j-1>=0){
                    int minSteps=w[i][j-1];
                    int currSteps=steps+1;
                    if(a[i][j-1]==2)
                    currSteps=0;
                    if(currSteps<minSteps)
                    q.add(new int[]{i,j-1,currSteps});
                }
                if(i+1<m){
                    int minSteps=w[i+1][j];
                    int currSteps=steps+1;
                    if(a[i+1][j]==2)
                    currSteps=0;
                    if(currSteps<minSteps)
                    q.add(new int[]{i+1,j,currSteps});
                }
                if(j+1<m){
                    int minSteps=w[i][j+1];
                    int currSteps=steps+1;
                    if(a[i][j+1]==2)
                    currSteps=0;
                    if(currSteps<minSteps)
                    q.add(new int[]{i,j+1,currSteps});
                }
            }
        }
    }
    public int shortestBridge(int[][] grid) {
        a=grid;
        m=grid.length;
        n=grid[0].length;
        boolean found =false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    dfs(i,j);
                    bfs(i,j);
                    found=true;
                    break;
                }
            }
            if(found)
            break;
        }
        return ans;
    }
}