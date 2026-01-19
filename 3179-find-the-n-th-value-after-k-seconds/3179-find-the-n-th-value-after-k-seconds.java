class Solution {
    public int valueAfterKSeconds(int n, int k) {
        int mod=1000000007;
        int[] a=new int[n];
        for(int i=0;i<n;i++)
        a[i]++;
        for(int j=0;j<k;j++){
            for(int i=0;i<n;i++){
                if(i==0)
                continue;
                long val=a[i]+a[i-1];
                val=val%mod;
                a[i]=(int)val;
            }
        }
        return a[n-1];
    }
}