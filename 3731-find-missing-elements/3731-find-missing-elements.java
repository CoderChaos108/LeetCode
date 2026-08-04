class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int l=101;
        int r=0;
        for(int i:nums){
            set.add(i);
            l=Math.min(l,i);
            r=Math.max(i,r);
        }
        List<Integer> list=new ArrayList<>();
        for(int i=l;i<=r;i++){
            if(!set.contains(i))
            list.add(i);
        }
        return list;
    }
}