class Solution {
    int c;
    boolean[] res;
    HashMap<Integer,List<Integer>> hm=new HashMap<>();
    public void dfs(int node){
        if(res[node])
        return;
        c++;
        res[node]=true;
        for(int i:hm.get(node)){
            dfs(i);
        }
    }
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        c=0;
        res=new boolean[n];
        for(int i=0;i<edges.length;i++){
            int a=edges[i][0];
            int b=edges[i][1];
            if(!hm.containsKey(a)){
                List<Integer> list=new ArrayList<>();
                list.add(b);
                hm.put(a,list);
            }
            else
            hm.get(a).add(b);
            if(!hm.containsKey(b)){
                List<Integer> list=new ArrayList<>();
                list.add(a);
                hm.put(b,list);
            }
            else
            hm.get(b).add(a);
        }
        for(int i:restricted)
        res[i]=true;
        dfs(0);
        return c;
    }
}