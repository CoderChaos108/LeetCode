class Solution {
    public boolean isPowerOfTwo(int n) {
        while(n!=2&&n!=1){
            n=n<<1;
        }
        if(n==2)
        return true;
        return false;
    }
}