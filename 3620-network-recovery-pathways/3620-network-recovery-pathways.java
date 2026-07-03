class Solution {
    int n;
    public boolean bfs(List<int[]>[] graph,boolean[] online,long k,int m){
        PriorityQueue<long[]> pq =
    new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));

            long[] dist=new long[n];
            Arrays.fill(dist,Long.MAX_VALUE);

            dist[0]=0;
            pq.add(new long[]{0,0});

            while(!pq.isEmpty()){
                long[] cur=pq.poll();

                int u=(int)cur[0];
                long d=cur[1];

                if(d!=dist[u]) continue;

                if(u==n-1) return d<=k;

                for(int[] e:graph[u]){
                    int v=e[0];
                    int w=e[1];

                    if(w<m) continue;
                    if(v!=n-1&&!online[v]) continue;

                    if(dist[v]>d+w){
                        dist[v]=d+w;
                        pq.add(new long[]{v,dist[v]});
                    }
                }
            }

            return false;
    }
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        n=online.length;
        int ans=-1;
        int l=0;
        int r=0;
        List<int[]>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++)
        graph[i]=new ArrayList<>();
        for(int[] a:edges){
            int u=a[0];
            int v=a[1];
            int c=a[2];
            r=Math.max(c,r);
            graph[u].add(new int[]{v,c});
        }
       
        while(l<=r){
            int m=l+(r-l)/2;
            if(bfs(graph,online,k,m)){
                l=m+1;
                ans=Math.max(ans,m);
            }
            else{
                r=m-1;
            }
        }
        return ans;
    }
}