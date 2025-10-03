class LockingTree {
    int[] parent;
    int[] locker;
    List<Integer>[] tree;
    boolean found;
    public LockingTree(int[] parent) {
        this.parent=parent;
        locker=new int[parent.length];
        tree=new ArrayList[parent.length];
        for(int i=0;i<parent.length;i++)
        tree[i]=new ArrayList<>();
        for(int i=0;i<parent.length;i++){
            if(parent[i]==-1)
            continue;
            tree[parent[i]].add(i);
        }
    }
    
    public boolean lock(int num, int user) {
        if(locker[num]!=0)
        return false;
        locker[num]=user;
        return true;
    }
    
    public boolean unlock(int num, int user) {
        if(locker[num]==user){
        locker[num]=0;
        return true;
        }
        return false;
    }
    public boolean check(int node){
        if(node==-1)
        return true;
        if(locker[node]!=0)
        return false;
        return check(parent[node]);
    }
    public void dfs(int node){
        if(locker[node]!=0){
        found=true;
        locker[node]=0;
        }
        for(int child:tree[node])
        dfs(child);
    }
    public boolean upgrade(int num, int user) {
        if(check(num)==false)
        return false;
        found=false;
        dfs(num);
        if(!found)
        return false;
        locker[num]=user;
        return true;
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */