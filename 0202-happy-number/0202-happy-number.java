class Solution {
    static boolean recur(int n,int i){
        if(i==100)
        return false;
        i++;
        int s=0;
        while(n!=0){
            s=s+(n%10)*(n%10);
            n=n/10;
        }
        if(s==1)
        return true;
        return recur(s,i);
        
    }
    public boolean isHappy(int n) {
        return recur(n,0);
    }
}