class Solution {
    int[] ans;
    int factor=1000000007;
    List<List<Integer>>[] graph;
    public void dfs(int node,int w){
        ans[node]=w;
        for(List<Integer> l:graph[node]){
            int newNode=l.get(0);
            long newW=(1L*w*l.get(1))%factor;
            dfs(newNode,(int)newW);
        }
    }
    public int[] baseUnitConversions(int[][] conversions) {
        int n=conversions.length+1;
        graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        ans=new int[n];
        for(int[] a:conversions){
            graph[a[0]].add(Arrays.asList(a[1],a[2]));
        }
        dfs(0,1);
        return ans;
    }
}