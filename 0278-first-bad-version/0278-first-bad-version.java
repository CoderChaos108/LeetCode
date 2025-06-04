/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l=1;
        int r=n;
        int m=0;
        while(l>0){
            m=l/2+r/2;
            if(m==0)
            m=1;
            if(isBadVersion(m)){
            if (!isBadVersion(m-1)||m==0)
            return m;
            else
            r=m-1;
            }
            else
            l=m+1;

        }
        return 0;
    }
}