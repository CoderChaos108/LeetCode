class Solution {
    int[][] a;
    int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    List<List<Integer>> grid;
    int m,n;
    public int bfs(int r,int c){
        Queue<int[]> q=new LinkedList<>();
        boolean[][] seen=new boolean[m][n];
        q.add(new int[]{r,c});
        int dis=0;
        while(true){
            int size=q.size();
            for(int k=0;k<size;k++){
                int[] arr=q.poll();
                int i=arr[0];
                int j=arr[1];
                if(seen[i][j])
                continue;
                seen[i][j]=true;
                if(grid.get(i).get(j)==1){
                    return dis;
                }
                for(int[] v:dir){
                    int ni=i+v[0];
                    int nj=j+v[1];
                    if(ni>=0&&nj>=0&&ni<m&&nj<n)
                    q.add(new int[]{ni,nj});
                }
            }
            dis++;
        }
    }
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        if(grid.get(0).get(0)==1)
        return 0;
        this.grid=grid;
         m=grid.size();
        n=grid.get(0).size();
        a=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j]=bfs(i,j);
            }
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[2]-a[2]);
        pq.add(new int[]{0,0,a[0][0]});
        boolean seen[][]=new boolean[m][n];
        while(true){
            int[] arr=pq.poll();
            int i=arr[0];
            int j=arr[1];
            int safety=arr[2];
            if(safety==0)
            return 0;
            if(seen[i][j])
            continue;
            seen[i][j]=true;
            if(i==m-1&&j==n-1)
            return safety;
            for(int[] v:dir){
                int ni=i+v[0];
                int nj=j+v[1];
                if(ni<0||nj<0||ni==m||nj==n)
                continue;
                int newSafety=Math.min(safety,a[ni][nj]);
                pq.add(new int[]{ni,nj,newSafety});
            }
        }
    }
}