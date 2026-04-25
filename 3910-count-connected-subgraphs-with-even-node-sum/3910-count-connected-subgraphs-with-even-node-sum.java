class Solution {
    List<Integer>[] graph;
    int ans=0;
    int[] a;
    public void find(HashSet<Integer> s){
        HashSet<Integer> seen=new HashSet<>();
        for(int i:s){
            dfs(i,seen,s);
            break;
        }
        int sum=0;
        if(seen.equals(s)){
            for(int i:s)
            sum=sum+a[i];
            if(sum%2==0)
            ans++;
        }
    }
    public void dfs(int node,HashSet<Integer> seen,HashSet<Integer> set){
        if(seen.contains(node))
        return;
        seen.add(node);
        for(int neigh:graph[node]){
            if(set.contains(neigh))
            dfs(neigh,seen,set);
        }
    }
    public void backtrack(int i,HashSet<Integer> set){
        int n=a.length;
        if(i==n){
            if(set.size()!=0){
                find(set);
            }
            return;
        }
        set.add(i);
        backtrack(i+1,set);
        set.remove(i);
        backtrack(i+1,set);
    }
    public int evenSumSubgraphs(int[] nums, int[][] edges) {
        graph=new ArrayList[nums.length];
        for(int i=0;i<nums.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] arr:edges){
            int u=arr[0];
            int v=arr[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        a=nums;
        backtrack(0,new HashSet<>());
        return ans;
    }
}