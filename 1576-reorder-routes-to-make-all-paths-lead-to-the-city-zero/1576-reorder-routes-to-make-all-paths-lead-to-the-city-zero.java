class Solution {
    List<List<List<Integer>>> graph=new ArrayList<>();
    boolean[] seen;
    int c=0;
    public void dfs(int node){
        if(seen[node])
        return;
        seen[node]=true;
        for(int out:graph.get(node).get(0)){
            if(!seen[out]){
                c++;
                dfs(out);
            }
        }
            for(int in:graph.get(node).get(1)){
                if(!seen[in])
                dfs(in);
            }
    }
    public int minReorder(int n, int[][] connections) {
        seen=new boolean[n];
        for(int i=0;i<n;i++){
            List<List<Integer>> list=new ArrayList<>();
            list.add(new ArrayList<>());
            list.add(new ArrayList<>());
            graph.add(list);
        }
        for(int[] a:connections){
            int x=a[0];
            int y=a[1];
            graph.get(x).get(0).add(y);
            graph.get(y).get(1).add(x);
        }
        dfs(0);
        return c;
    }
}