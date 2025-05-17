class Solution {
    public int maxProfit(int[] prices) {
        int s=prices[0];
        int p=0;           
        int l=prices.length;
        for(int i=1;i<l;i++){
            if(prices[i]-s>0){
                p=p+prices[i]-s;
                s=prices[i];
            }
            if(prices[i]<s)
            s=prices[i];
        }
        return p;
    }
}