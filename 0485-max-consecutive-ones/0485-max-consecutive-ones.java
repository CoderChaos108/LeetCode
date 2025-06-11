class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int l=0;
        int k=0;
        for(int i=0;i<nums.length-l;i++){
            if(nums[i]==1){
                k=1;
                while(i!=nums.length-1&&nums[i+1]==1){
                    k++;
                    i++;
                }
            }
            if(k>l)
            l=k;
        }
        return l;
    }
}