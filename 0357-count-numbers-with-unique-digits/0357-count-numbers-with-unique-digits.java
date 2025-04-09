class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0)
        return 1;
        int s=10;
        int m=9;
        int mul=9;
            for(int j=1;j<n;j++){
                m=m*mul;
                mul--;
                s=s+m;        
            }
        return s;
    }
}