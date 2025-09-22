class Solution {
    int ans=0;
    int target;
    public void find(int[] a,int sum,int k){
        if(k==a.length){
            if(sum==target)
            ans++;
            return;
        }
        find(a,sum+a[k],k+1);
        find(a,sum-a[k],k+1);
    }
    public int findTargetSumWays(int[] nums, int target2) {
        target=target2;
        find(nums,0,0);
        return ans;
    }
}