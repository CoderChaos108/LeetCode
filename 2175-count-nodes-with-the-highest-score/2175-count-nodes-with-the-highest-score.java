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
        HashMap<Long,Integer> hm=new HashMap<>();
        dfs(0);
        long ans=0;
        int m=0;
        for(int i=0;i<n;i++){
            int parent=0;
            int left=0;
            int right=0;
            List<Integer> list=tree.get(i);
            if(parents[i]!=-1)
            parent=n-nodes[i];
            if(list.size()!=0)
            left=nodes[list.get(0)];
            if(list.size()==2)
            right=nodes[list.get(1)];
            long product=1;
            if(parent>0)
            product=product*parent;
            if(left>0)
            product=product*left;
            if(right>0)
            product=product*right;
            if(product>ans)
            ans=product;
            hm.put(product,hm.getOrDefault(product,0)+1);
        }
        return hm.get(ans);
    }
}