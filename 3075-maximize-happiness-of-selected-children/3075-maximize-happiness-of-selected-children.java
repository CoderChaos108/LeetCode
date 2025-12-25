class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long ans=0;
        int itr=0;
        for(int i=happiness.length-1;i>=0&&itr<k;i--){
            happiness[i]=happiness[i]-itr++;
            if(happiness[i]<=0)
            break;
            ans=ans+happiness[i];
        }
        return ans;
    }
}