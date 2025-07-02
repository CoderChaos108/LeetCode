class Solution {
    HashMap<Integer,Integer> hm;
    int k;
    Random rand;
    public Solution(int n, int[] a) {
        Arrays.sort(a);
        rand=new Random();
        hm=new HashMap<>();
        int p=0;
        int q=a.length-1;
        while(p<=q){
            if(a[q]==n-1){
                q--;
                n--;
                continue;
            }
            hm.put(a[p],n-1);
            p++;
            n--;
        }
        k=n;

    }
    
    public int pick() {
        int r=(rand.nextInt(k));
        return hm.getOrDefault(r,r);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */