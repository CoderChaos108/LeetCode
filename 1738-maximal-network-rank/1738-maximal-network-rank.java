class Solution {
    List<HashSet<Integer>> graph=new ArrayList<>();
    public int maximalNetworkRank(int n, int[][] roads) {
        for(int i=0;i<n;i++)
        graph.add(new HashSet<>());
        for(int[] a:roads){
            int c1=a[0];
            int c2=a[1];
            graph.get(c1).add(c2);
            graph.get(c2).add(c1);
        }
        int m=0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int rank=graph.get(i).size()+graph.get(j).size();
                if(graph.get(i).contains(j))
                rank--;
                m=Math.max(m,rank);
            }
        }
        return m;
    }
}