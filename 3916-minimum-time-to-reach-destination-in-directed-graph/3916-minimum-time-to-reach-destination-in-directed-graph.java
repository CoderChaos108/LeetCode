class Solution {
    public int minTime(int n, int[][] edges) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        List<List<Integer>>[] graph=new ArrayList[n];
        boolean[] seen=new boolean[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] a:edges){
            graph[a[0]].add(Arrays.asList(a[1],a[2],a[3]));
        }
        pq.add(new int[]{0,0});
        while(!pq.isEmpty()){
            int[] a=pq.poll();
            int time=a[0];
            int node=a[1];
            if(seen[node])
            continue;
            seen[node]=true;
            if(node==n-1)
            return time;
            for(List<Integer> list:graph[node]){
                int newNode=list.get(0);
                int minTime=list.get(1);
                int maxTime=list.get(2)+1;
                int newTime=Math.max(time+1,minTime+1);
                if(maxTime>=newTime){
                pq.add(new int[]{newTime,newNode});
                }
            }
        }
        return -1;
    }
}