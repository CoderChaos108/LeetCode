class Solution {
    int[] a;
    int len;
    int[] map;
    public int count(int l,int r){
        int m=r-l+1;
        if(map[m]!=0)
        return map[m];
        if(l==r)
        return 1;
        int s=0;
        s=s+count(l+1,r)+count(l,r-1);
        for(int i=l+1;i<=r-1;i++){
            s=s+(count(i+1,r)*count(l,i-1));
        }
        map[m]=s;
        return s;
    }
    public int numTrees(int n) {
         map=new int[20];
        len=n-1;
        a=new int[n];
        for(int i=0;i<n;i++)
        a[i]=i+1;
        return count(0,n-1);
    }
}