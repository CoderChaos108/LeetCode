class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<List<Integer>>> graph=new ArrayList<>();
        int m=Integer.MAX_VALUE;
        int ans=0;
        int k=distanceThreshold;
        for(int i=0;i<n;i++){
        graph.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int x=edges[i][0];
            int y=edges[i][1];
            int w=edges[i][2];
            graph.get(y).add(Arrays.asList(w,x));
            graph.get(x).add(Arrays.asList(w,y));
        }
        for(int i=0;i<n;i++){
            PriorityQueue<List<Integer>> pq=new PriorityQueue<>((a,b)->a.get(0)-b.get(0));
            int[] a=new int[n];
            for(int j=0;j<n;j++)
            a[j]=Integer.MAX_VALUE;
            a[i]=0;
            pq.add(Arrays.asList(0,i));
            int cities=-1;
            while(!pq.isEmpty()){
                List<Integer> list=pq.poll();
                int dis=list.get(0);
                int node=list.get(1);
                if(dis>k)
                continue;
                for(List<Integer> neigh:graph.get(node)){
                    int newNode=neigh.get(1);
                    int newVal=neigh.get(0)+dis;
                    if(newVal<a[newNode]&&newVal<=k){
                        a[newNode]=newVal;
                        pq.add(Arrays.asList(newVal,newNode));
                        }
                    }
                }
                for(int j=0;j<n;j++){
                    if(a[j]<=k)
                    cities++;
                }
            if(m>=cities){
                m=cities;
                ans=i;
            }
        }
        return ans;
    }
}