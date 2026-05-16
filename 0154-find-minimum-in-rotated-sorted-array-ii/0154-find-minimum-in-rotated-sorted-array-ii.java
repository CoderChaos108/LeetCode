class Solution {
    public int bs(int l,int r,int[] nums){
        while(l<=r){
            if(l==r)
            return nums[l];
             int m=(l+r)/2;
            if(nums[l]<nums[r])
            return nums[l];
           
            else if(nums[l]>nums[r]){
                if(nums[m]>nums[r]){
                    return bs(m+1,r,nums);
                }
                else if(nums[m]<=nums[r])
                return bs(l,m,nums);
                
            }
            else{
                if(m==l)
                return nums[l];
                return Math.min(bs(l,m,nums),bs(m,r,nums));
            }
        }
        return nums[l];
    }
    public int findMin(int[] nums) {
        int l=0;
        int r=nums.length-1;
        return bs(l,r,nums);
    }
}