class Solution {
    public boolean check(int num){
        int[] a=new int[10];
        while(num!=0){
            int dig=num%10;
            a[dig]++;
            if(a[dig]>dig)
            return false;
            num=num/10;
        }
        for(int i=0;i<10;i++){
            if(a[i]!=i&&a[i]!=0)
            return false;
        }
        return true;
    }
    public int nextBeautifulNumber(int n) {
        n++;
        while(true){
            if(check(n))
            return n;
            n++;
        }
    }
}