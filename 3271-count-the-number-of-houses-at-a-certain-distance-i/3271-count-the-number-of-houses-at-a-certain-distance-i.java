class Solution {
    List<Integer>[] graph;
    boolean[] seen;
    int[] ans;
    public void bfs(int node){
        Queue<Integer> q=new LinkedList<>();
        q.add(node);
        int d=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int currentNode=q.poll();
                if(seen[currentNode])
                continue;
                seen[currentNode]=true;
                if(d!=0)
                ans[d-1]++;
                for(int neigh:graph[currentNode])
                q.add(neigh);
            }
            d++;
        }
    }
    public int[] countOfPairs(int n, int x, int y) {
    ans=new int[n];
    seen=new boolean[n+1];
     graph=new ArrayList[n+1];
     for(int i=1;i<=n;i++)
     graph[i]=new ArrayList<>();
     for(int i=1;i<n;i++){
        graph[i].add(i+1);
        graph[i+1].add(i);
     }
     graph[x].add(y);
     graph[y].add(x);
     for(int i=1;i<=n;i++){
        bfs(i);
        seen=new boolean[n+1];
     }
     return ans;
    }
}