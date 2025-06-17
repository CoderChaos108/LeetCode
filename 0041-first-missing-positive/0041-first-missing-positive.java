class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums)
        set.add(i);
        int n=1;
        while(true){
            if(!set.contains(n))
            return n;
            n++;
        }
    }
}