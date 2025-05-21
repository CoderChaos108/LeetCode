class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int l=nums.length;
        int c=0;
        int d=0;
        for(int i=0;i<l-2;i++){
            d=nums[i+1]-nums[i];
            for(int j=i+2;j<l;j++){
                if(nums[j]-nums[j-1]==d)
                c++;
                else
                break;
            }
        }
        return c;
    }
}