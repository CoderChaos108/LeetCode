class Solution {
    public int countElements(int[] nums, int k) {
       Arrays.sort(nums);
       int ans=0;
       int c=0;
       for(int i=0;i<nums.length;i++){
            if(i!=0&&nums[i-1]!=nums[i]){
                if(nums.length-1-(i-1)>=k){
                    ans=ans+c;
                }
                c=0;
            }
            c++;
       }
       return ans;
    }
}