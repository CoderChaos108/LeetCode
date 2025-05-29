class Solution {
    public boolean isPerfectSquare(int num) {
        if(num==1)
        return true;
        long l=0;
        long r=num;
        long m=(l+r)/2;
        while(r-l>1){
            m=(l+r)/2;
            if(m*m==num)
            return true;
            else if(m*m>num)
            r=m;
            else if(m*m<num)
            l=m;
        }
        return false;
    }
}
