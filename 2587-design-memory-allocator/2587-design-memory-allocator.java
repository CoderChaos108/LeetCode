class Allocator {
    HashMap<Integer,List<Integer>> hm;
    boolean[] a;
    public Allocator(int n) {
        hm=new HashMap<>();
        a=new boolean[n];
    }
    
    public int allocate(int size, int mID) {
        int cons=0;
        if(!hm.containsKey(mID))
        hm.put(mID,new ArrayList<>());
        for(int i=0;i<a.length;i++){
            if(a[i])
            cons=0;
            else{
                cons++;
                if(cons==size){
                    for(int j=i;j>i-size;j--){
                        hm.get(mID).add(j);
                        a[j]=true;
                    }
                    return i-size+1;
                }
            }
        }
        return -1;
    }
    
    public int freeMemory(int mID) {
        if(!hm.containsKey(mID))
        return 0;
        int ans=hm.get(mID).size();
        for(int i:hm.get(mID))
        a[i]=false;
        hm.get(mID).clear();
        return ans;
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.freeMemory(mID);
 */