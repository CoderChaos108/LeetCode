class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    int[] a;
    int n;
    public void find(List<Integer> list,int k){
        ans.add(new ArrayList<>(list));
        for(int i=k;i<n;i++){
            if(i!=k&&a[i]==a[i-1])
            continue;
            list.add(a[i]);
            find(list,i+1);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        a=nums;
        n=a.length;
        find(new ArrayList<>(),0);
        return ans;
    }
}