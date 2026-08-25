class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums)
        set.add(i);
        int t=k;
        while(true){
            if(!set.contains(t))
            return t;
            t=t+k;
        }
    }
}