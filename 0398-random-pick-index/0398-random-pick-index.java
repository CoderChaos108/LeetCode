class Solution {
    Random rand;
    HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>();
    public Solution(int[] nums) {
        rand=new Random();
        int l=nums.length;
        for(int i=0;i<l;i++){
            if(!hm.containsKey(nums[i])){
                ArrayList<Integer> list=new ArrayList<Integer>();
                list.add(i);
                hm.put(nums[i],list);
            }
            else
            hm.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        
        return hm.get(target).get(rand.nextInt(hm.get(target).size()));     
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */