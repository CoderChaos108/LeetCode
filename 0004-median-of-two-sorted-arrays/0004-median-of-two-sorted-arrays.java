class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1=0;
        int l2=0;
        int c=0;
        double s=0;
        if((nums1.length+nums2.length)%2!=0){
            while(l1!=nums1.length||l2!=nums2.length){
            if(l1==nums1.length){
                c++;
                if(c==((nums1.length+nums2.length)+1)/2)
                return nums2[l2];
                l2++;
            }
            else if(l2==nums2.length){
                c++;
                if(c==((nums1.length+nums2.length)+1)/2)
                return nums1[l1];
                l1++;
            }
            else{
                c++;
                if(nums1[l1]>nums2[l2]){
                    if(c==((nums1.length+nums2.length)+1)/2)
                    return nums2[l2];
                    l2++;
                }
                else{
                    if(c==((nums1.length+nums2.length)+1)/2)
                    return nums1[l1];
                    l1++;
                }
            }
            }
        }
        else{
            while(l1!=nums1.length||l2!=nums2.length){
                if(l2==nums2.length){
                    c++;
                    if(c==((nums1.length+nums2.length)/2))
                    s=nums1[l1];
                    else if(c==((nums1.length+nums2.length)/2)+1)
                    return (s+nums1[l1])/2;
                    l1++;                    
                }
                else if(nums1.length==l1){
                    c++;
                    if(c==((nums1.length+nums2.length)/2))
                    s=nums2[l2];
                    else if(c==((nums1.length+nums2.length)/2)+1)
                    return (s+nums2[l2])/2;
                    l2++;
                }
                else{
                     c++;
                    if(nums1[l1]<nums2[l2]){
                        if(c==((nums1.length+nums2.length)/2))
                    s=nums1[l1];
                    else if(c==((nums1.length+nums2.length)/2)+1)
                    return (s+nums1[l1])/2;
                    l1++;
                    }
                    else{
                        if(c==((nums1.length+nums2.length)/2))
                    s=nums2[l2];
                    else if(c==((nums1.length+nums2.length)/2)+1)
                    return (s+nums2[l2])/2;
                    l2++;
                    }
                }
            }
        }
        return s;
    }
}