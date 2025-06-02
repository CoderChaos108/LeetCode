class Solution {
    int a[];
    int t[];
    int l;
    int r;
    int[] reset;
    Random rand;
    int temp;
    public Solution(int[] nums) {
        reset=nums;
        r=0;
        temp=0;
        a=nums.clone();
        l=a.length;
        rand=new Random();
        t=new int[l];
    }
    
    public int[] reset() {
        return reset;
    }
    
    public int[] shuffle() {
        for(int i=l;i>0;i--){
            r=rand.nextInt(i);
            t[l-i]=a[r];
            temp=a[r];
            a[r]=a[i-1];
            a[i-1]=temp;
        }
        return t;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */