class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ans=0;
        int a=Math.max(cost1,cost2);
        int b=Math.min(cost1,cost2);
        cost1=a;
        cost2=b;
        for(int i=0;i*cost1<=total;i++){
            ans=ans+(total-cost1*i)/cost2+1;
        }
        return ans;
    }
}