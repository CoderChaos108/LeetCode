class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> tm=new HashMap<>();
        int l=0;
        int ans=0;
        for(int r=0;r<nums.length;r++){
            tm.put(nums[r],tm.getOrDefault(nums[r],0)+1);
            while(l<=r&&tm.get(nums[r])>k){
                tm.put(nums[l],tm.get(nums[l])-1);
                l++;
            }
            ans=Math.max(ans,r-l+1);
        }
        
            return ans;           
    }
}