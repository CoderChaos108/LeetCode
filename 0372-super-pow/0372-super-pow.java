class Solution {
    int mod=1337;
    public int find(int a,int dig,int dec){
        long p=power(a,dig);
        for(int i=0;i<dec;i++){
            p=power(p,10);
            p=p%mod;
        }
        p=p%mod;
        return (int)p;
    }
    public int power(long a,long b){
        long res=1;
        while(b>0){
            a=a%mod;
            if((b&1)==1)
            res=res*a;
            a=a*a;
            b=b>>1;
        }
        res=res%mod;
        int ans=(int)res;
        return ans;
    }
    public int superPow(int a, int[] b) {
        long ans=1;
        int dec=0;
        for(int i=b.length-1;i>=0;i--){
            ans=ans*find(a,b[i],dec);
            ans=ans%mod;
            dec++;
        }
        return (int)(ans%mod);
    }
}