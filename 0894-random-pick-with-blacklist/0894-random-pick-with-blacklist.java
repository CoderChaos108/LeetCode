class Solution {
    HashMap<Integer,Integer> hm;
    int k;
    Random rand;
    public static void sort(int[] nums){
        if(nums.length!=0){
        int len=nums.length;
        int s=nums[0];
        int l=nums[0];
        for(int i:nums){
        l=Math.max(l,i);
        s=Math.min(s,i);
        }
        if(l>10000000||(l-s)>len)
        Arrays.sort(nums);
        else{
        int[] f=new int[l+1];
        for(int i:nums){
            f[i]++;
        }
        int x=0;
        for(int i=s;i<=l;i++){
            if(f[i]>0){
                nums[x]=i;
                x++;
            }
        }
        }
        }
    }
    public Solution(int n, int[] a) {
        sort(a);
        rand=new Random();
        hm=new HashMap<>();
        int p=0;
        int q=a.length-1;
        if(a.length==1){
            if(a[0]==n-1)
            n--;
            else{
                hm.put(a[0],n-1);
                n--;
            }
        }
        else{

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