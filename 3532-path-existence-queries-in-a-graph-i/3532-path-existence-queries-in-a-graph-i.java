class Solution {
    int[] parent;
    public int findParent(int node){
        if(parent[node]==node)
        return node;
        return parent[node]=findParent(parent[node]);
    }
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        parent=new int[n];
        for(int i=0;i<n;i++)
        parent[i]=i;
        for(int i=1;i<n;i++){
            int lim=nums[i-1]+maxDiff;
            if(nums[i]<=lim){
                parent[findParent(i)]=findParent(i-1);
            }
        }
        boolean[] ans=new boolean[queries.length];
        for(int i=0;i<queries.length;i++){
            int u=queries[i][0];
            int v=queries[i][1];
            if(findParent(u)==findParent(v))
            ans[i]=true;
        }
        return ans;
    }
}