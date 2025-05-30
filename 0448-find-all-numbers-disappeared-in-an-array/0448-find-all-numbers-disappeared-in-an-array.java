class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] a=new int[nums.length+1];
        for(int i:nums)
        a[i]++;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=1;i<a.length;i++){
            if(a[i]==0)
            list.add(i);
        }
        return list;
    }
}