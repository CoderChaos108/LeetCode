class Solution {
    public int maxProfit(int[] prices) {
        int s=prices[0];
        int p=0;
        for(int i:prices){
            if(i-s>p)
            p=i-s;
            if(i<s)
            s=i;
        }
        return p;
    }
}