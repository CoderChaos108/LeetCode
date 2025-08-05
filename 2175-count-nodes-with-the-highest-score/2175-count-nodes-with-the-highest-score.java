class Solution {
    List<List<Integer>> tree=new ArrayList<>();
    int[] nodes;
    public void dfs(int node){
        int c=1;
        for(int n:tree.get(node)){
            dfs(n);
            c=c+nodes[n];
        }
        nodes[node]=c;
    }
    public int countHighestScoreNodes(int[] parents) {
        int n=parents.length;
        nodes=new int[n];
        for(int i=0;i<n;i++){
            tree.add(new ArrayList<>());
        }
        for(int i=0;i<parents.length;i++){
            int p=parents[i];
            if(p!=-1)
            tree.get(p).add(i);
        }
        HashMap<Integer,Integer> hm=new HashMap<>();
        dfs(0);
        int ans=0;
        int m=0;
        for(int i=0;i<n;i++){
            int parent=1;
            int left=1;
            int right=1;
            List<Integer> list=tree.get(i);
            if(parents[i]!=-1)
            parent=nodes[0]-nodes[i];
            if(list.size()!=0)
            left=nodes[list.get(0)];
            if(list.size()==2)
            right=nodes[list.get(1)];
            int product=parent*left*right;
            ans=Math.max(ans,product);
            hm.put(product,hm.getOrDefault(product,0)+1);
        }
        return hm.get(ans);
    }
}