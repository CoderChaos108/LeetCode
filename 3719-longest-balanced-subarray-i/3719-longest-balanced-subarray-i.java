class Solution {
    public int longestBalanced(int[] nums) {
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            int even=0;
            int odd=0;
            HashSet<Integer> set=new HashSet<>();
            for(int j=i;j<n;j++){
                if(!set.contains(nums[j])){
                if(nums[j]%2==0)
                even++;
                else
                odd++;
                }
                set.add(nums[j]);
                if(even==odd)
                ans=Math.max(ans,j-i+1);
            }
        }
        return ans;
    }
}