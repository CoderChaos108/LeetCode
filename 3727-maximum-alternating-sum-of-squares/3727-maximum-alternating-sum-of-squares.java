class Solution {
    public long maxAlternatingSum(int[] nums) {
        long ans=0;
        for(int i=0;i<nums.length;i++){
            nums[i]=Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        int l=0;
        int r=nums.length-1;
        while(l<r){
            ans=ans+(nums[r]*nums[r])-(nums[l]*nums[l]);
            l++;
            r--;
        }
        if(l==r)
        ans=ans+nums[r]*nums[r];
        return ans;
    }
}