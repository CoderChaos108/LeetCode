class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    int[] a;
    int target;
    public void find(List<Integer> list,int sum,int k){
        if(sum==target){
            ans.add(list);
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
        for(int i=0;i<a.length;i++){
            List<Integer> list=new ArrayList<>();
            list.add(a[i]);
            find(list,a[i],i);
        }
        return ans;
    }
}