class Solution {
    public int mySqrt(int x) {
        double l=0;
        double r=Math.min(46340,x);
        double m=(l+r)/2;
        while((int)(m*m)!=x){
            m=(l+r)/2;
            if(m*m<(double)x){
                l=m+1;
            }
            else
            r=m-1;
        }
        return(int)m;
    }
}