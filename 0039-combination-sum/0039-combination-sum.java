class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    int[] a;
    int target;
    public void find(List<Integer> list,int sum,int k){
        if(sum==target){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(sum>target)
        return;
        else{
            for(int i=k;i<a.length;i++){
                List<Integer> list2=new ArrayList<>(list);
                list2.add(a[i]);
                find(list2,sum+a[i],i);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int t) {
        a=candidates;
        target=t;
        find(new ArrayList<>(),0,0);
        return ans;
    }
}