class Solution {
    public int differenceOfSums(int n, int m) {
        int s=n*(n+1)/2;
        int num2=0;
        for(int i=1;m*i<=n;i++)
        num2=num2+m*i;
        return s-2*num2;
    }
}