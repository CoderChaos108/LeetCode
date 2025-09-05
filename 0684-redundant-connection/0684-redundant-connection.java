class Solution {
    int[] parent,rank;
    public int findParent(int node){
        if(parent[node]==node)
        return node;
        int nodeParent=findParent(parent[node]);
        parent[node]=nodeParent;
        return nodeParent;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        parent=new int[n+1];
        rank=new int[n+1];
        for(int i=1;i<=n;i++)
        parent[i]=i;
        for(int[] a:edges){
            int parent1=findParent(a[0]);
            int parent2=findParent(a[1]);
            if(parent1==parent2)
            return a;
            int rank1=rank[parent1];
            int rank2=rank[parent2];
            if(rank2>rank1){
                parent[parent1]=parent2;
            }
            else if(rank1>rank2){
                parent[parent2]=parent1;
            }
            else{
                parent[parent2]=parent1;
                rank[parent1]=rank[parent1]+1;
            }
        }
        return new int[0];
    }
}