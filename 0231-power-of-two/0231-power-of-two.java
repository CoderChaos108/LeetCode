class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==1)
        return true;
        if(n<1)
        return false;
        if(n%2!=0)
        return false;
        if(n%3==0||n%5==0||n%7==0)
        return false;
        if(n%2!=0){
        if(n!=1)
        return false;
        if(n==1)
        return true;
        }
            return isPowerOfTwo(n/2);
    }
}