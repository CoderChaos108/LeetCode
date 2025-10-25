class Solution {
    public int totalMoney(int n) {
        int last=0;
        int sum=0;
        int cash=0;
        int i=0;
        while(n!=0){
            i=i%7;
            if(i==0){
            cash=++last;
            }
            sum=sum+cash;
            cash++;
            n--;
            i++;
        }
        return sum;
    }
}