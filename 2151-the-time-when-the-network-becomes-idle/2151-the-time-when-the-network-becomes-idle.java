class Solution {
    int[] dis;
    List<Integer>[] graph;
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n=patience.length;
        int ans=-1;
        dis=new int[n];
        graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        int distance=1;
        for(int[] a:edges){
            int x=a[0];
            int y=a[1];
            graph[x].add(y);
            graph[y].add(x);
        }
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int node=q.poll();
                if(dis[node]!=0)
                continue;
                dis[node]=distance;
                for(int neigh:graph[node])
                q.add(neigh);
            }
            distance++;
        }
        for(int i=1;i<n;i++){
            int d=2*(dis[i]-1);
            int pat=patience[i];
            int lastSent=((d-1)/pat)*pat;
            int val=lastSent+d;
            if(pat>d)
            val=d;
            ans=Math.max(ans,val);
        }
        return ans+1;
    }
}