class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<Integer>();
        int l=0;
        for(int i:nums){
            if(set.add(i)==false)
            return true;
            else
            set.add(i);
            
        }
        return false;
    }
}