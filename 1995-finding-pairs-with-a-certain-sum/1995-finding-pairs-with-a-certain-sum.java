class FindSumPairs {
    int[] a;
    int[] b;
    HashMap<Integer,Integer> hm;
    public FindSumPairs(int[] nums1, int[] nums2) {
        a=nums1;
        b=nums2;
        hm=new HashMap<>();
        for(int i:nums2){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
    }
    
    public void add(int index, int val) {
        int old=b[index];
        b[index]+=val;
        int cur=b[index];
        hm.put(old,hm.get(old)-1);
        hm.put(cur,hm.getOrDefault(cur,0)+1);
    }
    
    public int count(int tot) {
        int c=0;
        for(int i:a){
            c=c+hm.getOrDefault(tot-i,0);
        }
        return c;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */