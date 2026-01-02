class Solution {
    public int repeatedNTimes(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int itr=0;
        while(true){
            if(!set.add(nums[itr]))
            return nums[itr];
            itr++;
        }
    }
}