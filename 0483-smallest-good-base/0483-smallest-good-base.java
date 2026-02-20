class Solution {
    public long rem(long k,long n){
        long sum=0;
        long curr=1;
        while(true){
            if(sum>n-curr)
                break;
            sum=sum+curr;
            if(curr>n/k)  
                break;
            curr=curr*k;
        }
        return n-sum;
    }
    public long powerFinder(long k,long n){
        long pow=0;
        long sum=0;
        long curr=1;
        while(true){
            if(sum>n-curr) 
                break;
            sum=sum+curr;
            pow++;
            if(curr>n/k)
                break;
            curr=curr*k;
        }
        return pow;
    }
    public String smallestGoodBase(String num) {
        long n=Long.valueOf(num);
        String s="";
        long power=powerFinder(2,n);
        long curr=2;
        for(long pow=power;pow>=2;pow--){
            long m=-1;
            long l=curr;
            long r=n-1;
            while(l<=r){
                m=l+(r-l)/2;
                long p=powerFinder(m,n);
                if(p==pow){
                    curr=m;
                    l=m+1;
                }
                else if(p<pow){
                    r=m-1;
                }
                else{
                    l=m+1;
                }
            }
            if(rem(curr,n)==0)
            return String.valueOf(curr);
            curr++;
        }
        return String.valueOf(n-1);
    }
}