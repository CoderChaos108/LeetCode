class Solution {
    public void moveZeroes(int[] nums) {
        int x=0;
        for(int i:nums){
            if(i!=0){
            nums[x]=i;
            x++;
            }
        }
        for(int i=x;i<nums.length;i++)
        nums[i]=0;
    }
}