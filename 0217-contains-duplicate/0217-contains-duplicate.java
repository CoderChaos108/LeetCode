class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<Integer>();
        int l=0;
        for(int i:nums){
            l=set.size();
            set.add(i);
            if(set.size()==l)
            return true;
            
        }
        return false;
    }
}