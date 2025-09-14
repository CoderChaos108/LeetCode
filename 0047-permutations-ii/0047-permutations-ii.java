class Solution {
    HashSet<List<Integer>> ans=new HashSet<>();
    int[] a;
    int n;
    HashSet<Integer> set=new HashSet<>();
    public void find(List<Integer> list,int k){
        if(list.size()==n){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<n;i++){
            if(set.contains(i))
            continue;
            set.add(i);
            list.add(a[i]);
            find(list,i);
            list.remove(list.size()-1);
            set.remove(i);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        a=nums;
        n=a.length;
        find(new ArrayList<>(),-1);
        return new ArrayList<>(ans);
    }
}