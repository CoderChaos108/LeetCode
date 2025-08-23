class Solution {
    boolean[] seen;
    List<HashSet<Integer>> graph=new ArrayList<>();
    int c=0;
    List<Integer> list=new ArrayList<>();
    public void dfs(int node){
        if(seen[node])
        return;
        seen[node]=true;
        list.add(node);
        for(int neigh:graph.get(node))
        dfs(neigh);
    }
    public boolean checker(List<Integer> list){
        for(int i:list){
            for(int node:list){
                if(!graph.get(i).contains(node)&&node!=i)
                return false;
            }
        }
        return true;
    }

    public int countCompleteComponents(int n, int[][] edges) {
        seen=new boolean[n];
        for(int i=0;i<n;i++)
        graph.add(new HashSet<>());
        for(int[] a:edges){
            graph.get(a[0]).add(a[1]);
            graph.get(a[1]).add(a[0]);
        }
        for(int i=0;i<n;i++){
            if(!seen[i]){
                list=new ArrayList<>();
                dfs(i);
                if(checker(list))
                c++;
            }
        }
        return c;
    }
}