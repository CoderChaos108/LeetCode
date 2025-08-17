class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<int[]>> graph=new ArrayList<>();
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
            graph.get(y).add(new int[]{w,x});
            graph.get(x).add(new int[]{w,y});
        }
        for(int i=0;i<n;i++){
            PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
            int[] a=new int[n];
            for(int j=0;j<n;j++)
                a[j]=Integer.MAX_VALUE;
            a[i]=0;
            pq.add(new int[]{0,i});
            int cities=-1;
            while(!pq.isEmpty()){
                int[] arr=pq.poll();
                int dis=arr[0];
                int node=arr[1];
                if(dis>k)
                    continue;
                for(int[] neigh:graph.get(node)){
                    int newNode=neigh[1];
                    int newVal=neigh[0]+dis;
                    if(newVal<a[newNode]&&newVal<=k){
                        a[newNode]=newVal;
                        pq.add(new int[]{newVal,newNode});
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
