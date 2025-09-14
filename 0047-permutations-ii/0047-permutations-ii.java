class Solution {
    Set<List<Integer>> ans=new HashSet<>();
    int[] a;
    int n;
    boolean[] seen;
    public void find(List<Integer> list,int k){
        if(list.size()==n){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<n;i++){
            if(seen[i])
            continue;
            seen[i]=true;
            list.add(a[i]);
            find(list,i);
            list.remove(list.size()-1);
            seen[i]=false;
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        a=nums;
        n=a.length;
        seen=new boolean[n];
        find(new ArrayList<>(),-1);
        return new ArrayList<>(ans);
    }
}