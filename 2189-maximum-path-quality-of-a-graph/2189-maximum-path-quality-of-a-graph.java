class Solution {
    List<List<List<Integer>>> graph=new ArrayList<>();
    int maxTime;
    int[] vals;
    int max=Integer.MIN_VALUE;
    public void dfs(int node,int time,int val,boolean[] seen){
        if(time>maxTime)
        return;
        boolean firstVisit=false;
        if(!seen[node]){
        val=val+vals[node];
        seen[node]=true;
        firstVisit=true;
        }
        if(node==0)
        max=Math.max(max,val);
        for(List<Integer> l:graph.get(node)){
            int newTime=l.get(0)+time;
            int newNode=l.get(1);
            dfs(newNode,newTime,val,seen);
        }
        if(firstVisit)
        seen[node]=false;
    }
    public int maximalPathQuality(int[] values, int[][] edges, int mt) {
        vals=values;
        maxTime=mt;
        boolean[] seen;
        int n=values.length;
        seen=new boolean[n];
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int a=edges[i][0];
            int b=edges[i][1];
            int t=edges[i][2];
            graph.get(a).add(Arrays.asList(t,b));
            graph.get(b).add(Arrays.asList(t,a));
        }
        
        dfs(0,0,0,seen);
        return max;
    }
}