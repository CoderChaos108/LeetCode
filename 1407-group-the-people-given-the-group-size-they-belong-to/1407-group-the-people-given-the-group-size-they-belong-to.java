class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer,List<Integer>> hm=new HashMap<>();
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<groupSizes.length;i++){
            int t=groupSizes[i];
            if(hm.containsKey(t))
            hm.get(t).add(i);
            else{
                List<Integer> list=new ArrayList<>();
                list.add(i);
                hm.put(t,list);
            }
            if(hm.get(t).size()==t){
                ans.add(hm.get(t));
                List<Integer> empty=new ArrayList<>();
                hm.put(t,empty);
            }
        }
        return ans;
    }
}