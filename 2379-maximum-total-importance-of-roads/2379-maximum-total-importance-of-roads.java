class Solution {
    public long maximumImportance(int n, int[][] roads) {
     int[] values=new int[n];
     List<Integer> [] graph=new ArrayList[n];
     PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
        return graph[a].size()-graph[b].size();
     });
     for(int i=0;i<n;i++)
     graph[i]=new ArrayList<>();
     for(int[] a:roads){
        int x=a[0];
        int y=a[1];
        graph[x].add(y);
        graph[y].add(x);
     }
    for(int i=0;i<n;i++){
        pq.add(i);
    }
    for(int i=1;i<=n;i++){
        int node=pq.poll();
        values[node]=i;
    }
    long ans=0;
    for(int i=0;i<n;i++){
        for(int neigh:graph[i]){
            ans=ans+values[i]+values[neigh];
        }
    }
    return ans/2;
    }
}