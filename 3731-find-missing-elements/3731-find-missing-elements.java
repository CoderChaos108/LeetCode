class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int l=101;
        int r=0;
        Arrays.sort(nums);
        l=nums[0];
        r=nums[nums.length-1];
        int idx=0;
        List<Integer> list=new ArrayList<>();
        for(int i=l;i<=r;i++){
           if( nums[idx]!=i)
            list.add(i);
            else
            idx++;
        }
        return list;
    }
}