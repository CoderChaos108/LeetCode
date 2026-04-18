class Solution {
    public long reverse(int n){
        long res=0;
        int a=n;
        while(a!=0){
            int d=a%10;
            res=res*10+d;
            a=a/10;
        }
        return res;
    }
    public int mirrorDistance(int n) {
        long ans=Math.abs(n-reverse(n));
        return (int)ans;       
    }
}