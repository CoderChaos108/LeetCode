class Solution {
    Stack<Integer> st=new Stack<>();
    List<Integer>[] graph;
    int count=0;
    boolean[] seen;
    public void dfs(int node,int[] adj){
        if(node==-1||seen[node])
        return;
        seen[node]=true;
        dfs(adj[node],adj);
        st.push(node);
    }
    public void dfs2(int node){
        if(seen[node])
        return;
        seen[node]=true;
        count++;
        for(int neigh:graph[node])
        dfs2(neigh);
    }
    public int longestCycle(int[] edges) {
        int n=edges.length;
        graph=new ArrayList[n];
        seen=new boolean[n];
        for(int i=0;i<n;i++){
            if(!seen[i])
            dfs(i,edges);
        }
        for(int i=0;i<n;i++)
        graph[i]=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(edges[i]!=-1)
            graph[edges[i]].add(i);
        }
        seen=new boolean[n];
        int ans=-1;
        while(!st.isEmpty()){
            int node=st.pop();
            if(seen[node])
            continue;
            dfs2(node);
            if(count!=1)
            ans=Math.max(count,ans);
            count=0;
        }
        return ans;
    }
}