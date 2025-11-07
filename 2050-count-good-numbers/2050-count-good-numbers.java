class Solution {
    long MOD=1000000007;

    long modPow(long base,long exp){
        long result=1;
        while(exp>0){
            if((exp&1)==1)
                result=(result*base)%MOD;
            base=(base*base)%MOD;
            exp>>=1;
        }
        return result;
    }

    public int countGoodNumbers(long n){
        if(n%2==0)
            return (int)(modPow(20,n/2)%MOD);
        else{
            long part1=modPow(5,n/2+1);
            long part2=modPow(4,n/2);
            return (int)((part1*part2)%MOD);
        }
    }
}
