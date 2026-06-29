class Solution {
    public long[] minTimeMaxPower(int n, int[][] edges, int iniPower, int[] cost, int source, int target) {
        List<int[]>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++)
        graph[i]=new ArrayList<>();
        for(int[] a:edges){
            int u=a[0];
            int v=a[1];
            graph[u].add(new int[]{v,a[2]});
            
        }
        long ansTime=-1;
        long ansPower=-1;
        boolean[][] seen=new boolean[n][iniPower+1];
        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
        pq.add(new long[]{source,0,iniPower});
        while(!pq.isEmpty()){
            long[] a=pq.poll();
            int node=(int)a[0];
            long time=a[1];
            int power=(int)a[2];
            if(ansTime!=-1 && time>ansTime)
            break;
            if(power<0)
            continue;
            if(seen[node][power])
            continue;
            seen[node][power]=true;
            if(node==target){
                ansTime=time;
                ansPower=Math.max(power,ansPower);
                continue;
            }
            for(int[] arr:graph[node]){
                int newNode=arr[0];
                long newTime=time+arr[1];
                int newPower=power-cost[node];
                pq.add(new long[]{newNode,newTime,newPower});
            }
        }
        return new long[]{ansTime,ansPower};
    }
}