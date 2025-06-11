class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int k=0;
        int l=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1)
            k++;
            else{
                if(l<k)
                l=k;
                k=0;
            }
        }
         return Math.max(l,k);
    }
}