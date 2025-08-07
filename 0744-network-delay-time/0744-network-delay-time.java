class Solution {
    List<List<int[]>> graph=new ArrayList<>();
    int[] distance;
    public int networkDelayTime(int[][] times,int n,int k) {
        distance=new int[n+1];
        for(int i=0;i<=n;i++) {
            graph.add(new ArrayList<>());
            distance[i]=Integer.MAX_VALUE;
        }
        distance[k]=0;
        for(int i=0;i<times.length;i++) {
            List<int[]> list=graph.get(times[i][0]);
            list.add(new int[]{times[i][1],times[i][2]});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,k});
        while(!pq.isEmpty()) {
            int[] l=pq.poll();
            int d=l[0];
            int current=l[1];
            if(d>distance[current]) continue;
            for(int[] list:graph.get(current)) {
                int node=list[0];
                int curDis=d+list[1];
                if(distance[node]>curDis) {
                    distance[node]=curDis;
                    pq.add(new int[]{curDis,node});
                }
            }
        }
        int ans=-1;
        for(int i=1;i<=n;i++) {
            if(distance[i]==Integer.MAX_VALUE)
            return -1;
            ans=Math.max(ans,distance[i]);
        }
        return ans;
    }
}
