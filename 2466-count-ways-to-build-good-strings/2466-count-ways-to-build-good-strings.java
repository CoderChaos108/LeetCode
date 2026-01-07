class Solution {
    int mod=1000000007;
    HashMap<Integer,Long> dp=new HashMap<>();
    public long count(int l,int low,int high,int zero,int one){
        if(l>high)
        return 0;
        if(dp.containsKey(l))
        return dp.get(l);
        int ret=0;
        if(l>=low&&l<=high){
            ret=1;
        }
        dp.put(l,(ret+count(l+one,low,high,zero,one)+count(l+zero,low,high,zero,one))%mod);
        return dp.get(l);
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        return (int)count(0,low,high,zero,one);
    }
}