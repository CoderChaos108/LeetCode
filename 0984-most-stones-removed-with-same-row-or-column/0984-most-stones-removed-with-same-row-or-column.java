class Solution {
    int[] parent,rank;
    public int getParent(int node){
        
        if(parent[node]==node)
        return node;
        int nodeParent=getParent(parent[node]);
        parent[node]=nodeParent;
        return nodeParent;
    }
    public int removeStones(int[][] stones) {
        int n=stones.length;
        parent=new int[n];
        rank=new int[n];
        int components=0;
        for(int i=0;i<n;i++)
        parent[i]=i;
        for(int i=0;i<n-1;i++){
            int x1=stones[i][0];
            int y1=stones[i][1];
            for(int j=i+1;j<n;j++){
                int x2=stones[j][0];
                int y2=stones[j][1];
                if(x1==x2||y1==y2){
                    int par1=getParent(i);
                    int par2=getParent(j);
                    int rank1=rank[par1];
                    int rank2=rank[par2];
                    if(rank1>rank2){
                        parent[par2]=par1;
                    }
                    else if(rank2>rank1)
                    parent[par1]=par2;
                    else{
                        parent[par2]=par1;
                        rank[par1]++;
                    }
                }
            }
        }
        boolean[] seen=new boolean[n];
        for(int i=0;i<n;i++){
            int par=getParent(i);
            if(!seen[par]){
                seen[par]=true;
                components++;
            }
        }
        return n-components;
    }
}