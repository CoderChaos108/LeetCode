class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums)
        set.add(i);
        while(set.contains(original)){
            original=original<<1;
        }
        return original;
    }
}