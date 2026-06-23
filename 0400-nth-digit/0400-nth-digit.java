class Solution {
    public long counter(int n,int d){
        if(n/10==0)
        return n;
        long c=0;
            int m=(int)Math.pow(10,d-1)-1;
            c=c+(long)(n-m)*d;
            return c+counter(m,d-1);
    }
    public int findNthDigit(int n) {
        int l=1;
        int r=Integer.MAX_VALUE;
        while(l<=r){
            int m=(r-l)/2+l;
            int d=0;
            int temp=m;
            while(temp!=0){
                temp=temp/10;
                d++;
            }
            long c=counter(m,d);
            c=c-d;
            if(c<n&&n<=c+d){
                long idx=c+d;
               while(idx>n){
                    m/=10;
                    idx--;
                }
                return m%10;
            }
            if(n<=c){
                r=m-1;
            }
            else{
                l=m+1;
            }
            
        }
        return -1;
    }
}