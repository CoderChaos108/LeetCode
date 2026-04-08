class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod=1000000007;
        for(int[] a:queries){
            int l=a[0];
            int r=a[1];
            int k=a[2];
            int v=a[3];
            for(int j=l;j<=r;j=j+k){
                long res=nums[j];
                res=(res*v)%mod;
                nums[j]=(int)res;
            }
        }
        int xor=0;
        for(int i:nums)
        xor=xor^i;
        return xor;
    }
}