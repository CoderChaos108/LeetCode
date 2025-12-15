class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans=0;
        long c=1;  
        for(int i=1;i<prices.length;i++){
            if(prices[i-1]-1==prices[i]){
                c++;
            }
            else{
                ans=ans+c*(c+1)/2;
                c=1;
            }
        }
        
        ans=ans+c*(c+1)/2;
        return ans;
    }
}
