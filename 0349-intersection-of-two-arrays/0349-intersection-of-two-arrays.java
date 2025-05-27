class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set=new HashSet<>();
        HashSet<Integer> ans=new HashSet<>();
        for(int i:nums1)
        set.add(i);
        for(int i:nums2){
        if(set.contains(i))
        ans.add(i);
        }
        int[] a=new int[ans.size()];
        int x=0;
        for(int i:ans){
            a[x]=i;
            x++;
        }     
        return a;
    }
}