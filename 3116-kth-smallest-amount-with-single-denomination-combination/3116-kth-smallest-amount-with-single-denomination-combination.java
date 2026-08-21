class Solution {
    public long find(long n,int[] coins){
        long res=0;
        
        res=exclude(0,0,0,coins,n);
        return res;
    }
    public long exclude(int i,long a,int cnt,int[] coins,long n){
    if(i==coins.length){
        if(cnt==0)
            return 0;

        long x=n/a;

        if(cnt%2==1)
            return x;

        return -x;
    }

    long res=0;

    if(a==0)
        res+=exclude(i+1,coins[i],cnt+1,coins,n);
    else
        res+=exclude(i+1,lcm(a,(long)coins[i]),cnt+1,coins,n);

    res+=exclude(i+1,a,cnt,coins,n);

    return res;
}
    public long gcd(long a,long b){
        while(b!=0){
            long temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }
    public long lcm(long a,long b){
        long g=gcd(a,b);
        return a/g * b;
    }
    public long findKthSmallest(int[] coins, int k) {
        long l=1;
        long r=Long.MAX_VALUE;
        while(l<=r){
            long m=l+(r-l)/2;
            long t=find(m,coins);
            boolean findable=false;
            for(int i:coins){
                if(m%i==0)
                findable=true;
            }
            if(t==k&&findable)
            return m;
            else if(t>=k){
                r=m-1;
            }
            else
            l=m+1;
        }
        return -1;
    }
}