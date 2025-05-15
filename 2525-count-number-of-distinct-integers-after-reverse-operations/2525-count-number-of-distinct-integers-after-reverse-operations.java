class Solution {
    static int countDistinctIntegers(int[] nums) {
         Set<Integer> set=new HashSet<>();
         int x=0;
         for(int n:nums){
            x=0;
            set.add(n);
            while(n!=0){
            x=x*10+n%10;
            n=n/10;
        }
        set.add(x);
         }

        return set.size();
    }
}