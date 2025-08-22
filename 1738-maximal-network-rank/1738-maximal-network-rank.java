class Solution {
    int total;
    public class Node{
        int size=0;
        boolean[] set=new boolean[total]; 
    }
    List<Node> graph=new ArrayList<>();
    public int maximalNetworkRank(int n, int[][] roads) {
        total=n;
        for(int i=0;i<n;i++)
        graph.add(new Node());
        for(int[] a:roads){
            int c1=a[0];
            int c2=a[1];
            Node n1=graph.get(c1);
            Node n2=graph.get(c2);
            n1.set[c2]=true;
            n1.size++;
            n2.size++;
            n2.set[c1]=true;
        }
        int m=0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int rank=graph.get(i).size+graph.get(j).size;
                if(graph.get(i).set[j])
                rank--;
                m=Math.max(m,rank);
            }
        }
        return m;
    }
}