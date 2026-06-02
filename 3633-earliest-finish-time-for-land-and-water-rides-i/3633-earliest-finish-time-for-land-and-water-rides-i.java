class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int ans=Integer.MAX_VALUE;
        int n=landDuration.length;
        int m=waterDuration.length;
        for(int i=0;i<n;i++){
            int t=landStartTime[i]+landDuration[i];
            for(int j=0;j<m;j++){
                int time=Math.max(t,waterStartTime[j])+waterDuration[j];
                ans=Math.min(ans,time);
            }
        }
        for(int i=0;i<m;i++){
            int t=waterStartTime[i]+waterDuration[i];
            for(int j=0;j<n;j++){
                int time=Math.max(t,landStartTime[j])+landDuration[j];
                ans=Math.min(ans,time);
            }
        }
        return ans;
    }
}