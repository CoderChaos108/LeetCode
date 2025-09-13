class Graph {
    List<int[]>[] graph;
    public Graph(int n, int[][] edges) {
        graph=new ArrayList[n];
        for(int i=0;i<n;i++)
        graph[i]=new ArrayList<>();
        for(int[] a:edges){
            int x=a[0];
            int y=a[1];
            int w=a[2];
            graph[x].add(new int[]{y,w});
        }
    }
    
    public void addEdge(int[] edge) {
            int x=edge[0];
            int y=edge[1];
            int w=edge[2];
            graph[x].add(new int[]{y,w});
    }
    
    public int shortestPath(int node1, int node2) {
        int[] dis=new int[graph.length];
        for(int i=0;i<graph.length;i++)
        dis[i]=Integer.MAX_VALUE;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{node1,0});
        while(!pq.isEmpty()){
            int[] a=pq.poll();
            int node=a[0];
            int t=a[1];
            dis[node]=Math.min(dis[node],t);
            if(node==node2)
            return t;
            for(int[] neigh:graph[node]){
                int newNode=neigh[0];
                int newT=t+neigh[1];
                if(dis[newNode]>newT)
                pq.add(new int[]{newNode,newT});
            }
        }
        return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */