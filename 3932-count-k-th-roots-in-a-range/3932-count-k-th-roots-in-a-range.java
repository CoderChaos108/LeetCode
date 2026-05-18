class Solution {
    public int countKthRoots(int l, int r, int k) {
        int c=0;
        if(k==1)
        return r-l+1;
       for(int i=0;i<=Math.sqrt(r);i++){
            long res=1;
            for(int j=0;j<k;j++){
                res=res*i;
                if(res>r)
                break;
            }
            if(res>=l&&res<=r)
            c++;
       }
        return c;
    }
}