class Solution {
    int c;
    HashSet<Integer> set=new HashSet<>();
    HashMap<Integer,List<Integer>> hm=new HashMap<>();
    public void dfs(int node){
        if(set.contains(node))
        return;
        c++;
        set.add(node);
        for(int i:hm.get(node)){
            dfs(i);
        }
    }
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        c=0;
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
        set.add(i);
        dfs(0);
        return c;
    }
}