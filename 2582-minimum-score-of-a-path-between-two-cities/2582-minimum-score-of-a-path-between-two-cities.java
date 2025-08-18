class Solution {
    public int minScore(int n, int[][] roads) {
        int[] score=new int[n+1];
        for(int i=1;i<=n;i++)
        score[i]=Integer.MAX_VALUE;
        List<List<List<Integer>>> graph=new ArrayList<>();
        for(int i=0;i<=n;i++)
        graph.add(new ArrayList<>());
        for(int i=0;i<roads.length;i++){
            int x=roads[i][0];
            int y=roads[i][1];
            int w=roads[i][2];
            graph.get(x).add(Arrays.asList(w,y));
            graph.get(y).add(Arrays.asList(w,x));
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{Integer.MAX_VALUE,1});
        while(!pq.isEmpty()){
            int[] a=pq.poll();
            int w=a[0];
            int node=a[1];
            for(List<Integer> l:graph.get(node)){
                int newW=Math.min(w,l.get(0));
                int newNode=l.get(1);
                if(newW<score[newNode]){
                    score[newNode]=newW;
                    pq.add(new int[]{newW,newNode});
                }
            }
        }
        return score[n];
    }
}