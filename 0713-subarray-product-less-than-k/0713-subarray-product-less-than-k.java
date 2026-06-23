class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l=0;
        int ans=0;
        int n=nums.length;
        int p=1;
        if(k<=1)
        return 0;
        for(int r=0;r<n;r++){
            p=p*nums[r];
            while(p>=k){
                p=p/nums[l];
                l++;
            }
            ans=ans+(r-l+1);
        }
        return ans;
    }
}