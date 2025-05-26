class Solution {
    ArrayList<Integer> list;
    int[] a;
    int l;
    Random rand;
    public Solution(int[] nums) {
        l=nums.length;
        a=nums;
        
    }
    
    public int pick(int target) {
            list=new ArrayList<>();
            rand=new Random();
            for(int i=0;i<l;i++){
            if(a[i]==target)
            list.add(i);
        }
            return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */