class Solution {
    int[] a;
    List<List<Integer>> ans=new ArrayList<>();
    public void find(List<Integer> list,int k){
        ans.add(new ArrayList<>(list));
        for(int i=k;i<a.length;i++){
            list.add(a[i]);
            find(list,i+1);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        a=nums;
        find(new ArrayList<>(),0);
        return ans;
    }
}