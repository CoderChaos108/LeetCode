/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long l=1;
        long r=n;
        long m=0;
        while(l>0){
            m=(l+r)/2;
            if(isBadVersion((int)m)){
            if (!isBadVersion((int)m-1)||m==0)
            return (int)m;
            else
            r=m-1;
            }
            else
            l=m+1;

        }
        return 0;
    }
}