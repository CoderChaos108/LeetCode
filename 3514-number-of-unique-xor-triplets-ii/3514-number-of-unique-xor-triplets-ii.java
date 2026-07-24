class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Boolean> xorMap=new HashMap<>();
        for(int i=0;i<n;i++)
        for(int j=i;j<n;j++)
        xorMap.put(nums[i]^nums[j],true);

        HashSet<Integer> set=new HashSet<>();
        for(int x:xorMap.keySet())
        for(int i:nums)
        set.add(x^i);

        return set.size();
    }
}