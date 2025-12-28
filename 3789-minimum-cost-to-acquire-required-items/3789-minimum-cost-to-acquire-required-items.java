class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long ans=0;
        int common=Math.min(need1,need2);
        ans=(long)Math.min(cost1+cost2,costBoth)*common;
        int left=Math.max(need1,need2)-common;
        need1=need1-common;
        need2=need2-common;
        int cost=0;
        if(need1==0)
        cost=cost2;
        else
        cost=cost1;
        ans=ans+left*(long)Math.min(cost,costBoth);
        return ans;
    }
}