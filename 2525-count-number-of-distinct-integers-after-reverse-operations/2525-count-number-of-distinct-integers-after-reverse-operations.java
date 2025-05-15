class Solution {
    static int rev(int n){
        StringBuilder sb=new StringBuilder(String.valueOf(n));
        sb.reverse();
        return Integer.valueOf(sb.toString());
    }
    public int countDistinctIntegers(int[] nums) {
         Set<Integer> set=new HashSet<>();
         for(int i:nums){
            set.add(i);
            set.add(rev(i));
         }

        return set.size();
    }
}