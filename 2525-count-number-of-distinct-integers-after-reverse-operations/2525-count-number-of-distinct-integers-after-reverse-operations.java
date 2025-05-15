class Solution {
    static int rev(int n){
        int x=0;
        while(n!=0){
            x=x*10+n%10;
            n=n/10;
        }
        return x;
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