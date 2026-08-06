class Solution {
    public int product(int k){
        int n=k;
        int p=1;
        while(n!=0){
            p=p*(n%10);
            n=n/10;
        }
        return p;
    }
    public int smallestNumber(int n, int t) {
        while(true){
            if(product(n)%t==0)
            return n;
            n++;
        }
    }
}