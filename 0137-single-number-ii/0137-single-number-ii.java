class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])==false)
            hm.put(nums[i],1);
            else
            hm.put(nums[i],2);
        }
        for(int i:nums){
            if(hm.get(i)==1)
            return i;
        }
        return 0;
    }
}