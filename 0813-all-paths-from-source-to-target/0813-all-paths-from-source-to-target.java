class Solution {
    List<List<Integer>> path;
    int[][] a;
    int n;
    public void pathfinder(int node,List<Integer> list){
        if(node==n){
            list.add(node);
            path.add(list);
            return;
        }
        list.add(node);
        for(int i=0;i<a[node].length;i++){
            pathfinder(a[node][i],new ArrayList<>(list));
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
     path=new ArrayList<>();
     a=graph;
     n=graph.length-1;
     pathfinder(0,new ArrayList<>());
     return path;
    }
}