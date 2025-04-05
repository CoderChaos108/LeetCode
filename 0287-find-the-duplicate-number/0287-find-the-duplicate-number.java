class Solution {
    public int findDuplicate(int[] nums) {
        int l=1;
        for(int i:nums){
            if(l<i)
            l=i;
        }
        int[] a=new int[l+1];
        for(int i:nums){
            if(a[i]==1)
            return i;
            a[i]++;
        }
        return 0;
    }
}