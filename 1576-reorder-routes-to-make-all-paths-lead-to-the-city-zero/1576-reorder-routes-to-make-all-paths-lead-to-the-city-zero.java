class Solution {
    List<List<Integer>> graph=new ArrayList<>();
    boolean[] seen;
    int c=0;

    public void dfs(int node){
        if(seen[node])
        return;
        seen[node]=true;

        for(int next:graph.get(node)){
            if(!seen[Math.abs(next)]){
                if(next>0)
                    c++;
                dfs(Math.abs(next));
            }
        }
    }

    public int minReorder(int n, int[][] connections) {
        seen=new boolean[n];
        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());

        for(int[] a:connections){
            int x=a[0];
            int y=a[1];
            graph.get(x).add(+y);
            graph.get(y).add(-x);
        }

        dfs(0);
        return c;
    }
}
