class Solution {
    public long minInitialStrength(int[] monsters, int[][] boosts) {
        int n=monsters.length;
        long[] bonus=new long[n];
        for(int[] a:boosts){
            int l=a[0];
            int r=a[1];
            int v=a[2];
            bonus[l]=bonus[l]+v;
            if(r!=n-1)
            bonus[Math.min(r+1,n-1)]=bonus[Math.min(r+1,n-1)]-v;
        }
        long s=0;
        for(int i=0;i<n;i++){
            s=s+bonus[i];
            bonus[i]=s;
        }
        long l=0;
        long r=0;
        for(int m:monsters)
        r=r+m;
        long ans=0;
        while(l<=r){
            long m=l+(r-l)/2;
            long x=m;
            for(int i=0;i<n&&x>=0;i++){
                long b=bonus[i];
                if(x<-b+monsters[i]){
                    x=-1;
                    break;
                }
                x=Math.max(0,x-monsters[i]);
            }
            if(x<0){
                l=m+1;
            }
            else{
                ans=m;
                r=m-1;
            }
        }
        return ans;
    }
}