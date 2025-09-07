class Solution {
    HashMap<Integer,ArrayList<Integer>> graph=new HashMap<>();
    ArrayList<Integer> path=new ArrayList<>();
    HashMap<Integer,Integer> inDegree=new HashMap<>();
    HashMap<Integer,Integer> outDegree=new HashMap<>();

    public void dfs(int node){
        ArrayList<Integer> neighs=graph.getOrDefault(node,new ArrayList<>());
        while(!neighs.isEmpty()){
            int next=neighs.remove(neighs.size()-1);
            dfs(next);
        }
        path.add(node); 
    }

    public int[][] validArrangement(int[][] pairs) {
        for(int[] a:pairs){
            int x=a[0], y=a[1];
            graph.computeIfAbsent(x,k->new ArrayList<>()).add(y);
            outDegree.put(x,outDegree.getOrDefault(x,0)+1);
            inDegree.put(y,inDegree.getOrDefault(y,0)+1);
        }

        int start=pairs[0][0];
        for(int node:graph.keySet()){
            int out=outDegree.getOrDefault(node,0);
            int in=inDegree.getOrDefault(node,0);
            if(out-in==1){
                start=node;
                break;
            }
        }

        dfs(start);

        int n=pairs.length;
        int[][] res=new int[n][2];
        for(int i=n;i>0;i--){
            res[n-i][0]=path.get(i);
            res[n-i][1]=path.get(i-1);
        }
        return res;
    }
}
