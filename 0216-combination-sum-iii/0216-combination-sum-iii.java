class Solution {
    int[] a=new int[9];
    int k;
    int target;
    List<List<Integer>> ans=new ArrayList<>();
    public void find(List<Integer> list,int sum,int j){
        if(list.size()==k){
            if(sum==target)
            ans.add(new ArrayList<>(list));
            return;
        }
        if(sum>target)
        return;
        for(int i=j;i<a.length;i++){
            list.add(i+1);
            find(list,sum+i+1,i+1);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k2, int n) {
        k=k2;
        target=n;
        find(new ArrayList<>(),0,0);
        return ans;
    }
}