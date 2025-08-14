class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Double[] p=new Double[n];
        List<List<double[]>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
            p[i]=0.0;
        }
        p[start_node]=1.0;
        for(int i=0;i<edges.length;i++){
            double x=edges[i][0];
            double y=edges[i][1];
            graph.get((int)x).add(new double[]{succProb[i],y});
            graph.get((int)y).add(new double[]{succProb[i],x});
        }
        PriorityQueue<double[]> pq=new PriorityQueue<>((a,b)->Double.compare(b[0],a[0]));
        pq.add(new double[]{(double)1,start_node});
        while(!pq.isEmpty()){
            int size=pq.size();
            for(int i=0;i<size;i++){
                double[] a=pq.poll();
                double curProb=a[0];
                double node=a[1];
                if((int)node==end_node)
                return curProb;
                for(double[] l:graph.get((int)node)){
                    double newProb=curProb*l[0];
                    double neigh=l[1];
                    if(newProb>p[(int)neigh]){
                        p[(int)neigh]=newProb;
                        pq.add(new double[]{newProb,neigh});
                    }
                }
            }
        }
        return 0.0;
    }
}