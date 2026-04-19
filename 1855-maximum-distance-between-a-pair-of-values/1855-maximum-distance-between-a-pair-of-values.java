class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int ans=0;
        for(int i=0;i<nums1.length;i++){
            int l=i;
            int r=nums2.length-1;
            int m=(l+r)/2;
            int j=-1;
            while(l<=r){
                m=(l+r)/2;
                if(nums1[i]<=nums2[m]){
                    j=m;
                    l=m+1;
                }
                else{
                    r=m-1;
                }
            }
            ans=Math.max(ans,j-i);
        }
        return ans;
    }
}