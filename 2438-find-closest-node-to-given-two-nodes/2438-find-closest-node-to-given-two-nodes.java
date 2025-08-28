class Solution {
    int[][] dis;
    int[] a;
    public void dfs(int node,int d,int x){
        if(node==-1||dis[x][node]!=0)
        return;
        dis[x][node]=d;
        dfs(a[node],d+1,x);
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        a=edges;
        int n=edges.length;
        int ans=-1;
         dis=new int[2][n];
        int d=Integer.MAX_VALUE;
        dfs(node1,1,0);
        dfs(node2,1,1);
        for(int i=0;i<n;i++){
            if(dis[0][i]==0||dis[1][i]==0)
            continue;
            int curDis=Math.max(dis[0][i],dis[1][i]);
            if(curDis<d){
                d=curDis;
                ans=i;
            }
        }
        return ans;
    }
}