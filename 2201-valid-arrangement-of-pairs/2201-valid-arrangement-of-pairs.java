class Solution {
    HashMap<Integer,ArrayList<Integer>> graph=new HashMap<>();
    LinkedList<Integer> path=new LinkedList<>();
    HashMap<Integer,Integer> inDegree=new HashMap<>();
    HashMap<Integer,Integer> outDegree=new HashMap<>();

    public void dfs(int node){
        ArrayList<Integer> neighs=graph.getOrDefault(node,new ArrayList<>());
        while(!neighs.isEmpty()){
            int next=neighs.remove(neighs.size()-1);
            dfs(next);
        }
        path.addFirst(node);
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
        Iterator<Integer> it=path.iterator();
        int prev=it.next();
        for(int i=0;i<n;i++){
            int curr=it.next();
            res[i][0]=prev;
            res[i][1]=curr;
            prev=curr;
        }
        return res;
    }
}
