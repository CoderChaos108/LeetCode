class Solution {
    public int minCost(int n, int[][] edges) {
        List<int[]>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++)
        graph[i]=new ArrayList<>();
        for(int[] a:edges){
            int u=a[0];
            int v=a[1];
            int w=a[2];
            graph[u].add(new int[]{v,w});
            graph[v].add(new int[]{u,2*w});
        }
        boolean[] seen=new boolean[n];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{0,0});
        while(!pq.isEmpty()){
            int[] a=pq.poll();
            int node=a[0];
            int w=a[1];
            if(node==n-1)
            return w;
            if(seen[node])
            continue;
            seen[node]=true;
            for(int[] neigh:graph[node]){
                int newNode=neigh[0];
                int newW=neigh[1];
                pq.add(new int[]{newNode,newW+w});
            }
        }
        return -1;
    }
}