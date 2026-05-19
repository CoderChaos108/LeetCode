class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int l=0;
        int r=0;
        while(l<nums1.length&&r<nums2.length){
            int i=nums1[l];
            int j=nums2[r];
            if(i==j)
            return i;
            if(i>j)
            r++;
            else
            l++;
        }
        return -1;
    }
}