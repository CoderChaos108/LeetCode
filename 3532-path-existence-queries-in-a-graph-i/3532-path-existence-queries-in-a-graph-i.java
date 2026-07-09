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
        for(int i=0;i<n;i++){
            int lim=nums[i]+maxDiff;
            int l=i;
            int r=n-1;
            int res=i;
            while(l<=r){
                int m=(l+r)/2;
                if(nums[m]<=lim){
                    l=m+1;
                    res=m;
                }
                else
                r=m-1;
            }
            int j=res;
            while(findParent(j)!=findParent(i)){
                parent[j]=findParent(i);
                j--;
            }
            i=Math.max(res-1,i);
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