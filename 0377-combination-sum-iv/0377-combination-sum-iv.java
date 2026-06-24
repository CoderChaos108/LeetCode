class Solution {
    int[] dp;
    public int find(int k,int[] a){
        if(k==0)
        return 1;
        if(dp[k]!=-1)
        return dp[k];
        int res=0;
        for(int i:a){
            if(k-i<0)
            continue;
            res=res+find(k-i,a);
        }
        dp[k]=res;
        return res;
    }
    public int combinationSum4(int[] nums, int target) {
        dp=new int[target+1];
        Arrays.fill(dp,-1);
        return find(target,nums);
    }
}