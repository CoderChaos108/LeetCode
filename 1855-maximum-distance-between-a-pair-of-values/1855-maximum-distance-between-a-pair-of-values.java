class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int l=0;
        int r=0;
        int ans=0;
        while(r<nums2.length&&l<nums1.length){
            if(nums2[r]>=nums1[l]){
                ans=Math.max(ans,r-l);
                r++;
            }
            else{
                l++;
            }
        }
        return ans;
    }
}