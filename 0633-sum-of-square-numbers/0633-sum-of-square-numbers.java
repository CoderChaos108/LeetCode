class Solution {
    public boolean judgeSquareSum(int c) {
        if(c==0)
        return true;
        for(int i=1;(long)i*i<=c;i++){
            int k=c-i*i;
            double b=Math.sqrt(k);
            if(b%1==0)
            return true;
        }
        return false;

    }
}