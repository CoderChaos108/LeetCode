class Solution {
    public int fib(int n) {
        if(n==0)
        return 0;
        if(n==1||n==2)
        return 1;
        int a=1;
        int b=1;
        int c=0;
        int k=2;
        while(k!=n){
            c=a+b;
            a=b;
            b=c;
            k++;
        }
        return c;
    }
}