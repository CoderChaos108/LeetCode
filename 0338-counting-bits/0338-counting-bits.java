class Solution {
    static int recur(int n){
        int c=0;
        while(n!=0){
            if(n%2==1)
            c++;
            n=n/2;
        }
        return c;
    }
    public int[] countBits(int n) {
        int a[]=new int[n+1];
        for(int i=0;i<=n;i++)
        a[i]=recur(i);
        return a;
    }
}