class Solution {
    Stack<Integer> st=new Stack();
    boolean[] seen;
    List<List<Integer>> graph;
    public void build(int node){
        if(seen[node])
        return;
        seen[node]=true;
        for(int i:graph.get(node))
        build(i);
        st.push(node);
    }
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        List<Integer> list=new ArrayList<>();
        int n=quiet.length;
        graph=new ArrayList<>();
        for(int i=0;i<n;i++)
        graph.add(new ArrayList<>());
        for(int[] a:richer){
            graph.get(a[0]).add(a[1]);
        }
         seen=new boolean[n];
        for(int i=0;i<n;i++){
            build(i);
        }
        int[] ans = new int[n];
        for (int i=0;i<n;i++)
        ans[i] = i;

        while (!st.isEmpty()) {
            int u = st.pop();
            for (int v:graph.get(u)) {
                if (quiet[ans[u]]<quiet[ans[v]]) {
                    ans[v]=ans[u];
                }
            }
        }
        return ans;
    }
}