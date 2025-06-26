class RLEIterator {
    int p;
    int t;
    int l;
    int[] nums;
    public RLEIterator(int[] encoding) {
        t=0;
        nums=encoding;
        p=1;
        l=nums.length;
    }
    
    public int next(int t) {
        if(p-1>=l)
        return -1;
        while(t>nums[p-1]){
            t=t-nums[p-1];
            p=p+2;
            if(p-1>=l)
            return -1;
        }
        nums[p-1]=nums[p-1]-t;
        return nums[p];
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */