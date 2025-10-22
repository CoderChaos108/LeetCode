class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
     List<int[]>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++)
        graph[i]=new ArrayList<>();
        for(int[] a:edges){
            int u=a[0];
            int v=a[1];
            int w=a[2];
            graph[u].add(new int[]{v,w});
            graph[v].add(new int[]{u,w});
        }
        int[] ans=new int[n];
        for(int i=0;i<n;i++)
        ans[i]=-1;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{0,0});
        while(!pq.isEmpty()){
            int[] a=pq.poll();
            int node=a[0];
            int w=a[1];
            if(ans[node]!=-1&&ans[node]<=w)
            continue;
            ans[node]=w;
            for(int[] neigh:graph[node]){
                int newNode=neigh[0];
                int newW=w+neigh[1];
                if(disappear[newNode]>newW&&(ans[newNode]==-1||ans[newNode]>newW))
                pq.add(new int[]{newNode,newW});
            }
        }
        return ans;
    }
}