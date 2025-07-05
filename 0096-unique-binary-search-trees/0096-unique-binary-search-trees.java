class Solution {
    int[] a;
    public int count(int l,int r){
        if(l==r)
        return 1;
        int s=0;
        for(int i=l;i<=r;i++){
            int left=1;
            if(i!=l)
            left=count(l,i-1);
            int right=1;
            if(i!=r)
            right=count(i+1,r);
            s=s+(right*left);
        }
        return s;
    }
    public int numTrees(int n) {
        a=new int[n];
        for(int i=0;i<n;i++)
        a[i]=i+1;
        return count(0,n-1);
    }
}