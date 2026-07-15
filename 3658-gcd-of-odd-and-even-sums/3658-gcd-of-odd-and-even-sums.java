class Solution {
    public int gcd(int a,int b){
        while(b!=0){
            int t=b;
            b=a%b;
            a=t;
        }
        return a;
    }
    public int gcdOfOddEvenSums(int n) {
        int gcdOdd=0;
        int gcdEven=0;
        int k=1;
        for(int i=1;i<=n;i++){
            gcdOdd=gcdOdd+k;
            gcdEven=gcdEven+k+1;
            k=k+2;
        }
        return gcd(gcdEven,gcdOdd);
    }
}