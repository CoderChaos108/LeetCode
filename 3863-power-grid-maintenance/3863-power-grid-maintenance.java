class Solution {
    int[] gm;
    TreeSet[] grids;
    List<Integer>[] graph;
    int numGrids=0;
    public void dfs(int node){
        if(gm[node]!=0)
        return;
        gm[node]=numGrids;
        grids[numGrids].add(node);
        for(int neigh:graph[node]){
            dfs(neigh);
        }
    }
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        gm=new int[c+1];
        grids=new TreeSet[c+1];
        graph=new ArrayList[c+1];
        for(int i=1;i<=c;i++){
            grids[i]=new TreeSet<>();
            graph[i]=new ArrayList<>();
        }
        for(int[] a:connections){
            int x=a[0];
            int y=a[1];
            graph[x].add(y);
            graph[y].add(x);
        }
        for(int i=1;i<=c;i++){
            if(gm[i]==0){
                numGrids++;
                dfs(i);
            }
        }
        int itr=-1;
        int n=0;
        for(int[] a:queries){
            if(a[0]==1)
            n++;
        }
        int[] ans=new int[n];
        for(int[] a:queries){
            int node=a[1];
            if(a[0]==2){
                grids[gm[node]].remove(node);
            }
            else{
                itr++;
                TreeSet<Integer> nodeSet=grids[gm[node]];
                if(nodeSet.contains(node)){
                    ans[itr]=node;
                    continue;
                }
                int id=-1;
                for(int i:nodeSet){
                    id=i;
                    break;
                }
                ans[itr]=id;
            }
        }
        return ans;
    }
}