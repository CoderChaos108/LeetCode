class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    int target;
    int[] a;
    public void find(List<Integer> list,int sum,int k){
        if(sum==target){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=k;i<a.length;i++){
            if(i>k&&a[i]==a[i-1])
            continue;
            if(sum+a[i]>target)
            return;
            list.add(a[i]);
            find(list,a[i]+sum,i+1);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int t) {
     Arrays.sort(candidates);   
     a=candidates;
     target=t;
    find(new ArrayList<>(),0,0);
    return ans;
    }
}