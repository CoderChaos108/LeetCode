class Solution {
    List<List<Integer>> path;
    int[][] a;
    int n;
    public void pathfinder(int node,List<Integer> list){
        if(node==n){
            list.add(node);
            path.add(new ArrayList<>(list));
        }
        else{
        list.add(node);
        for(int i=0;i<a[node].length;i++){
            pathfinder(a[node][i],list);
        }
        }
        list.remove(list.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
     path=new ArrayList<>();
     a=graph;
     n=graph.length-1;
     pathfinder(0,new ArrayList<>());
     return path;
    }
}