class Solution {
    public boolean hasZeros(int num){
        while(num!=0){
            if(num%10==0)
            return true;
            num=num/10;
        }
        return false;
    }
    public int[] getNoZeroIntegers(int n) {
        int l=0;
        int r=n;
        while(true){
            int m=(l+r)/2;
            int x=n-m;
            if(!hasZeros(x)&&!hasZeros(m))
            return new int[]{x,m};
            r=m;
        }
    }
}