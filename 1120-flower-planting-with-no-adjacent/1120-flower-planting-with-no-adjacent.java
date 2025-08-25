class Solution {
    int[] a;
    boolean[][] b;
    List<List<Integer>> graph=new ArrayList<>();
    public void color(int node){
        int flower=0;
        for(int i=1;i<5;i++){
            if(!b[node][i]){
                flower=i;
                break;
            }
        }
        a[node]=flower;
        for(int neigh:graph.get(node)){
            b[neigh][flower]=true;
        }
    }
    public int[] gardenNoAdj(int n, int[][] paths) {
        for(int i=0;i<n;i++)
        graph.add(new ArrayList<>());
        for(int[] arr:paths){
            int x=arr[0]-1;
            int y=arr[1]-1;
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        a=new int[n];
        b=new boolean[n][5];
        for(int i=0;i<n;i++){
            color(i);
        }
        return a;
    }
}