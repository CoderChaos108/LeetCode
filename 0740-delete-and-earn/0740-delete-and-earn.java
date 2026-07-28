class Solution {
    int[] dp;
    int n;
    public int find(int i,int[] a){
        if(i==n)
        return 0;
        if(dp[i]!=-1)
        return dp[i];
        int k=i;
        while(k<n&&a[k]==a[i])
        k++;
        int skip=find(k,a);
        int take=0;
        int j=i;
        while(j<n&&a[j]==a[i])
        take=take+a[j++];
        while(j<n&&a[j]==a[i]+1)
        j++;
        return dp[i]=Math.max(skip,take+find(j,a));
    }
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        n=nums.length;
        dp=new int[n];
        Arrays.fill(dp,-1);
        return find(0,nums);
    }
}