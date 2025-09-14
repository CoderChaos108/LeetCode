class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    int[] a;
    int target;
    HashSet<List<Integer>> set=new HashSet<>();
    public void find(List<Integer> list,int sum){
        if(sum==target){
            Collections.sort(list);
            if(set.contains(list))
            return;
            set.add(list);
            ans.add(list);
            return;
        }
        if(sum>target)
        return;
        else{
            for(int i:a){
                List<Integer> list2=new ArrayList<>(list);
                list2.add(i);
                find(list2,sum+i);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int t) {
        a=candidates;
        target=t;
        for(int i:a){
            List<Integer> list=new ArrayList<>();
            list.add(i);
            find(list,i);
        }
        return ans;
    }
}