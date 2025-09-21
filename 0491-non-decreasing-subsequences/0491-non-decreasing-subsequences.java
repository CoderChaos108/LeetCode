class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    int[] a;
    int n;
    public void find(List<Integer> list,int k){
        if(list.size()>1) ans.add(new ArrayList<>(list));
        HashSet<Integer> used=new HashSet<>();
        for(int i=k;i<n;i++){
            if(used.contains(a[i])) continue;
            if(list.size()==0||a[i]>=list.get(list.size()-1)){
                used.add(a[i]);
                list.add(a[i]);
                find(list,i+1);
                list.remove(list.size()-1);
            }
        }
    }
    public List<List<Integer>> findSubsequences(int[] nums){
        a=nums;
        n=a.length;
        find(new ArrayList<>(),0);
        return ans;
    }
}
