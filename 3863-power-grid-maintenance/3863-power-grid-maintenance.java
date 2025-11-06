class Solution {
    int[] gm;
    List<Integer>[] grids;
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

    public int[] processQueries(int c,int[][] connections,int[][] queries){
        gm=new int[c+1];
        grids=new ArrayList[c+1];
        graph=new ArrayList[c+1];
        for(int i=1;i<=c;i++){
            grids[i]=new ArrayList<>();
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

        for(int i=1;i<=numGrids;i++)
            Collections.sort(grids[i]);

        int itr=-1;
        int n=0;
        for(int[] a:queries)
            if(a[0]==1)
                n++;

        int[] ans=new int[n];
        for(int[] a:queries){
            int node=a[1];
            if(a[0]==2){
                if(gm[node]>=0)
                gm[node]=-gm[node];
            }
            else{
                itr++;
                if(gm[node]>0){
                    ans[itr]=node;
                    continue;
                }
                int gridId=Math.abs(gm[node]);
                List<Integer> nodeList=grids[gridId];
                int id=-1;
                for(int x:nodeList){
                    if(gm[x]>0){ 
                        id=x;
                        break;
                    }
                }
                ans[itr]=id;
            }
        }
        return ans;
    }
}
