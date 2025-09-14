class Solution {
    int[] a;
    int k;
    List<List<Integer>> ans=new ArrayList<>();
    public void find(List<Integer> list,int j){
        if(list.size()==k){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=j;i<a.length;i++){
            list.add(a[i]);
            find(list,i+1);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k2) {
        a=new int[n];
        k=k2;
        for(int i=0;i<n;i++)
        a[i]=i+1;
        find(new ArrayList<>(),0);
        return ans;
    }
}