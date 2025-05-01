class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap hm=new HashMap<>();
        for(int i:nums){
            if(hm.containsKey(i)==false)
            hm.put(i,1);
            else
            return true;
        }
        return false;
    }
}