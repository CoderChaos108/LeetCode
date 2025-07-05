class Solution {
    int[] a;
    int len;
    public int count(int l,int r){
        if(l==r)
        return 1;
        int s=0;
        s=s+count(l+1,r)+count(l,r-1);
        for(int i=l+1;i<=r-1;i++){
            s=s+(count(i+1,r)*count(l,i-1));
        }
        return s;
    }
    public int numTrees(int n) {
        len=n-1;
        a=new int[n];
        for(int i=0;i<n;i++)
        a[i]=i+1;
        return count(0,n-1);
    }
}