class Solution {
    Random rand;
    int s;
    int r;
    int[] a;
    public Solution(int[] w) {
        a=w.clone();
        for(int i=0;i<w.length;i++){
        s=s+a[i];
        a[i]=s;
        }
        rand=new Random();
    }
    
    public int pickIndex() {
        r=rand.nextInt(s)+1;
        for(int i=0;i<a.length;i++){
            if(a[i]>=r)
            return i;
        }
        return 0;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */