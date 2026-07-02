class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[2]-a[2]);
        pq.add(new int[]{0,0,health-grid.get(0).get(0)});
        int m=grid.size();
        int n=grid.get(0).size();
        boolean[][] seen=new boolean[m][n];
        while(!pq.isEmpty()){
            int[] a=pq.poll();
            int i=a[0];
            int j=a[1];
            if(seen[i][j])
            continue;
            seen[i][j]=true;
            int hp=a[2];
            if(hp<=0)
            continue;
            if(i==m-1&&j==n-1){
                if(hp>=1)
                return true;
                return false;
            }
            if(i-1>=0){
    pq.add(new int[]{i-1,j,hp-grid.get(i-1).get(j)});
            }
            if(j-1>=0){
                pq.add(new int[]{i,j-1,hp-grid.get(i).get(j-1)});
            }
            if(i+1<m){
                pq.add(new int[]{i+1,j,hp-grid.get(i+1).get(j)});
            }
            if(j+1<n){
                pq.add(new int[]{i,j+1,hp-grid.get(i).get(j+1)});
            }

        }
        return false;
    }
}