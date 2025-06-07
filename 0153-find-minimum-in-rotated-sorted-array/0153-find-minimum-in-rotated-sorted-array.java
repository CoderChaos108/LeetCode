class Solution {
    public int findMin(int[] nums) {
        int l=0;
        int r=(nums.length-1);
        int m;
        while(l<=r){
            m=l+(r-l)/2;
            if(nums[l]<=nums[r])
            return nums[l];
            if((m==nums.length-1||nums[m]<nums[m+1])&&(m==0||nums[m]<nums[m-1]))
            return nums[m];
            m=l+(r-l)/2;
            if(Math.abs(nums[m]-nums[l])>Math.abs(nums[m]-nums[r])){
                r=m-1;
            }
            else
            l=m+1;
        }
        return nums[l];
    }
}