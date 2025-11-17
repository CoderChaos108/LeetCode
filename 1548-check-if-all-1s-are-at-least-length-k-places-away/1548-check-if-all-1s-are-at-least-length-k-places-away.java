class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int walked=0;
        int start=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                start=i;
                break;
            }
        }
        for(int i=start+1;i<nums.length;i++){
            if(nums[i]==0){
                walked++;
            }
            else{
                if(walked<k)
                return false;
                walked=0;
            }
        }
        return true;
    }
}