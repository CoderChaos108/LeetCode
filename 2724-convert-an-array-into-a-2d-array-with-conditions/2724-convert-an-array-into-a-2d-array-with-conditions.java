class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i:nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        for(int i:hm.keySet()){
            int f=hm.get(i);
            for(int j=0;j<f;j++){
                if(ans.size()<=j){
                    List<Integer> list=new ArrayList<>();
                    list.add(i);
                    ans.add(list);
                }
                else
                ans.get(j).add(i);
            }
        }
        return ans;
    }
}