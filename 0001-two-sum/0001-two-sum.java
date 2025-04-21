class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int[] a=new int[2];
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],i);
        }
            for(int i=0;i<nums.length;i++){
                if(hm.containsKey(target-nums[i])){
                    a[0]=i;
                    a[1]=hm.get(target-nums[i]);
                    if(a[0]==a[1])
                    continue;
                    return a;
                }
            }
            return a;
    }
}