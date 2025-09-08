class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++)
        graph[i]=new ArrayList<>();
        for(int i=0;i<n-1;i++){
            graph[i].add(i+1);
        }
        int itr=0;
        int[] ans=new int[queries.length];
        for(int[] a:queries){
            boolean[] seen=new boolean[n];
            Queue<Integer> q=new LinkedList<>();
            graph[a[0]].add(a[1]);
            q.add(0);
            boolean found=false;
            int d=0;
            while(!found){
                 int size=q.size();
                 for(int i=0;i<size;i++){
                    int node=q.poll();
                    if(seen[node])
                    continue;
                    seen[node]=true;
                    if(node==n-1){
                        ans[itr]=d;
                        itr++;
                        found=true;
                        break;
                    }
                    for(int neigh:graph[node])
                    q.add(neigh);
                 }
                 d++;
            }
        }
        return ans;
    }
}