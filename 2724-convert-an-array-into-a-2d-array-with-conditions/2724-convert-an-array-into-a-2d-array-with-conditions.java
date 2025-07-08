class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        int k=nums[0];
        int c=0;
        for(int i:nums){
            if(i!=k){
                c=0;
                k=i;
            }
            if(ans.size()<=c){
                ArrayList<Integer> list=new ArrayList<>();
                list.add(i);
                ans.add(list);
            }
            else{
                ans.get(c).add(i);
            }
            c++;
        }
        return ans;
    }
}