class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<List<List<Integer>>> graph=new ArrayList<>();
        int n=points.length;
        HashMap<List<Integer>,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
        graph.add(new ArrayList<>());
        List<Integer> l=Arrays.asList(points[i][0],points[i][1]);
        hm.put(l,i);
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int dist=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                graph.get(i).add(Arrays.asList(dist,j));
                graph.get(j).add(Arrays.asList(dist,i));
            }
        }
        int s=0;
        boolean[] seen=new boolean[n];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0});
        while(!pq.isEmpty()){
            int[] a=pq.poll();
            int w=a[0];
            int node=a[1];
            if(seen[node])
            continue;
            seen[node]=true;
            s=s+w;
            for(List<Integer> l:graph.get(node)){
                if(!seen[l.get(1)])
                pq.add(new int[]{l.get(0),l.get(1)});
            }
        }
        return s;
    }
}