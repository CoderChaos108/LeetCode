class Solution {
    public int countSmall(int m,int n,int x){
        int c=0;
        for(int i=1;i<=m;i++){
            c=c+Math.min(n,(x-1)/i);
        }
        return c;
    }
    public int countLarge(int m,int n,int x){

        int c=0;
        for(int i=1;i<=m;i++){
            c=c+n-Math.min(n,x/i);
        }
        return c;
    }
    public int findKthNumber(int m, int n, int k) {
        int l=1;
        int r=m*n;
        while(l<=r){
            int x=(r-l)/2+l;
            int left=countSmall(m,n,x);
            int right=countLarge(m,n,x);
            int mid=m*n-(right+left);
            if(k<=left+mid&&k>left){
                return x;
            }
            if(k<=left)
            r=x-1;
            else
            l=x+1;
        }
        return -1;
    }
}