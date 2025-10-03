class LUPrefix {
    int max;
    boolean[] seen;
    public LUPrefix(int n) {
        max=0;
        seen=new boolean[n+1];
    }
    
    public void upload(int video) {
        seen[video]=true;
    }
    
    public int longest() {
        while(max+1!=seen.length&&seen[max+1])
        max++;
        return max;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */