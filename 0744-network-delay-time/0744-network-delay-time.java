class Solution {
    List<List<List<Integer>>> graph=new ArrayList<>();
    int[] distance;
    public int networkDelayTime(int[][] times, int n, int k) {
        distance=new int[n+1];
        for(int i=0;i<=n;i++){
        graph.add(new ArrayList<>());
        if(i!=k)
        distance[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<times.length;i++){
            List<List<Integer>> list=graph.get(times[i][0]);
            list.add(Arrays.asList(times[i][2],times[i][1]));
        }
        PriorityQueue<List<Integer>> pq=new PriorityQueue<>((a,b)->a.get(0)-b.get(0));
        pq.add(Arrays.asList(0,k));
        while(!pq.isEmpty()){
            List<Integer> l=pq.poll();
            int d=l.get(0);
            int current=l.get(1);
            for(List<Integer> list:graph.get(current)){
                int curDis=d+list.get(0);
                int node=list.get(1);
                if(distance[node]>curDis){
                    distance[node]=curDis;
                    pq.add(Arrays.asList(curDis,node));
                }
            }
        }
        int ans=-1;
        for(int i=1;i<=n;i++){
            if(distance[i]==Integer.MAX_VALUE)
            return -1;
            ans=Math.max(distance[i],ans);
        }
        return ans;
    }
}