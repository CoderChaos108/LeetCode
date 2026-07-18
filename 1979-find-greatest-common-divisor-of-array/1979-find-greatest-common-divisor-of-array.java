class Solution {
    public int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public int findGCD(int[] nums) {
        int max=0;
        int min=1000;
        for(int i:nums){
            max=Math.max(max,i);
            min=Math.min(min,i);
        }
        return gcd(max,min);
    }
}