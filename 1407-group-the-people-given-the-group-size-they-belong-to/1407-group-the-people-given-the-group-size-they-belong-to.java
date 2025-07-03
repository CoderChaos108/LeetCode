class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer,List<Integer>> hm=new HashMap<>();
        for(int i=0;i<groupSizes.length;i++){
            int t=groupSizes[i];
            if(hm.containsKey(t))
            hm.get(t).add(i);
            else{
                List<Integer> list=new ArrayList<>();
                list.add(i);
                hm.put(t,list);
            }
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int i:hm.keySet()){
            int count=0;
            List<Integer> list=new ArrayList<>();
            for(int j:hm.get(i)){
                list.add(j);
                if(list.size()==i){
                    ans.add(list);
                    list=new ArrayList<>();
                }
            }
        }
        return ans;
    }
}