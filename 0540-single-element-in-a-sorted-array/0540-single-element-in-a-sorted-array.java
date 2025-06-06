class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l=0;
        int m=0;
        int r=nums.length-1;
        while(l<r){
            m=l+(r-l)/2;
            if(r-l==2){
                if(nums[m-1]==nums[m])
                return nums[m+1];
                else
                return nums[m-1];
            }
            if(nums[m-1]==nums[m]){
                if((m-l)%2==0){
                    r=m;
                }
                else
                l=m+1;
            }
            else if(nums[m+1]==nums[m]){
                if((r-m)%2==0){
                    l=m;
                }
                else
                r=m-1;
            }
            else
            return nums[m];
        }
        return nums[l];
    }
}