class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> ans=new ArrayList<Integer>();
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        for(int i:nums){
            if(!hm.containsKey(i))
            hm.put(i,1);
            else
            hm.put(i,hm.get(i)+1);
            if((double)hm.get(i)>(double)(nums.length/3)&&(!ans.contains(i)))
            ans.add(i);
        }
        return ans;
    }
}