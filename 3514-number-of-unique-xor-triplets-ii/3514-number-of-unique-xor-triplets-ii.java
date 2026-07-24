class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        HashSet<Integer> xorSet=new HashSet<>();
        for(int i=0;i<n;i++)
        for(int j=i;j<n;j++)
        xorSet.add(nums[i]^nums[j]);
        HashSet<Integer> set=new HashSet<>();
        for(int x:xorSet)
        for(int i:nums)
        set.add(x^i);
        return set.size();
    }
}