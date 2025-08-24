import java.util.*;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        
        List<List<int[]>> graph=new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int dist=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                graph.get(i).add(new int[]{dist,j});
                graph.get(j).add(new int[]{dist,i});
            }
        }

        int cost=0;
        boolean[] seen=new boolean[n];
        int edgesUsed=0;

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0}); 

        while(edgesUsed<n){
            int[] curr=pq.poll();
            int w=curr[0],node=curr[1];
            if(seen[node]) continue;

            seen[node]=true;
            cost+=w;
            edgesUsed++;

            for(int[] nei:graph.get(node)){
                if(!seen[nei[1]]){
                    pq.add(new int[]{nei[0],nei[1]});
                }
            }
        }
        
        return cost;
    }
}
