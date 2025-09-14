class Solution {
    List<List<Integer>> ans=new ArrayList<>();
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
            if(i>0&&a[i-1]==a[i]&&!seen[i-1])
            continue;
            seen[i]=true;
            list.add(a[i]);
            find(list,i);
            list.remove(list.size()-1);
            seen[i]=false;
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        a=nums;
        n=a.length;
        seen=new boolean[n];
        find(new ArrayList<>(),-1);
        return ans;
    }
}