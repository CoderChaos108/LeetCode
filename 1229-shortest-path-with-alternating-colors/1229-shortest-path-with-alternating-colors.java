class Solution {
    boolean[][] seen;
    public int bfs(int target){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{1,0}); 
        int d=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] a=q.poll();
                int node=a[0];
                int color=a[1];
                int check=0;
                if(color==1)
                check=1;
                if(seen[node][check])
                continue;
                seen[node][check]=true;
                if(node-1==target) 
                return d;
                for(int neigh:graph[node]){
                    int newNode=Math.abs(neigh);
                    int newColor=neigh/Math.abs(neigh);
                    if(color==0){
                        q.add(new int[]{newNode,newColor});
                    }
                    else{
                        if(newColor!=color)
                        q.add(new int[]{newNode,newColor});
                    }
                }
            }
            d++;
        }
        return -1;
    }
    List<Integer>[] graph;
    public int[] shortestAlternatingPaths(int n,int[][] redEdges,int[][] blueEdges) {
        graph=new ArrayList[n+1]; 
        for(int i=0;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] a:redEdges){
            graph[a[0]+1].add(a[1]+1);   
        }
        for(int[] a:blueEdges){
            graph[a[0]+1].add(-(a[1]+1)); 
        }
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            seen=new boolean[n+1][2];
            ans[i]=bfs(i);
        }
        return ans;
    }
}
