class Solution {
    boolean[] seen;
    int[] lc,rc;
    public boolean dfs(int node){
        if(node==-1)
        return true;
        if(seen[node])
        return false;
        seen[node]=true;
        return dfs(lc[node])&&dfs(rc[node]);
    }
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        seen=new boolean[n];
        lc=leftChild;
        rc=rightChild;
        for(int i:lc){
            if(i==-1)
            continue;
            seen[i]=true;
        }
        for(int i:rc){
            if(i==-1)
            continue;
            seen[i]=true;
        }
        int root=-1;
        for(int i=0;i<n;i++){
            if(seen[i]==false){
                if(root!=-1)
                return false;
                root=i;
            }
        }
        if(root==-1)
        return false;
        seen=new boolean[n];
        if(!dfs(root))
        return false;
        for(boolean flag:seen){
            if(!flag)
            return false;
        }
        return true;
    }
}