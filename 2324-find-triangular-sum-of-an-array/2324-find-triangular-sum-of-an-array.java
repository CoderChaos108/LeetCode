class Solution {
    int[] a;
    public void find(int n){
        if(n<1)
        return;
        for(int i=0;i<n;i++){
            a[i]=(a[i]+a[i+1])%10;
        }
        find(n-1);
    }
    public int triangularSum(int[] nums) {
        a=nums;
        find(a.length-1);
        return a[0];
    }
}