class Solution {
    int[][] a;
    int[] state;
    
    public boolean safe(int n){
        if(state[n]==1)
        return false;
        if(state[n]==2)
        return true;
        state[n]=1;
        for(int i=0;i<a[n].length;i++){
            if(!safe(a[n][i]))
            return false;
        }
        state[n]=2;
        return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        a=graph;
        int n=graph.length;
        state=new int[n];
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(safe(i))
            ans.add(i);
        }
        return ans;
    }
}
