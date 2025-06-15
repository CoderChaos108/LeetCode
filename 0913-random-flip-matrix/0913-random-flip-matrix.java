class Solution {
    int rows;
    int cols;
    int total;
    Random rand;
    HashMap<Integer,Integer> hm;
    public Solution(int m, int n) {
        hm=new HashMap<>();
        rand=new Random();
        rows=m;
        cols=n;
        total=m*n;
    }
    
    public int[] flip() {
        int r=rand.nextInt(total);
        total--;
        int n=hm.getOrDefault(r,r);
        hm.put(r,hm.getOrDefault(total,total));
        return new int[]{n/cols,n%cols};
    }
    
    public void reset() {
        hm.clear();
        total=rows*cols;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */