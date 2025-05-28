class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> list=new ArrayList<>();
        int p=0;
        int q=0;
        while(p<nums1.length&&q<nums2.length){
            if(nums1[p]==nums2[q]){
                list.add(nums1[p]);
                p++;
                q++;
            }
            else if(nums1[p]>nums2[q]){
                q++;
            }
            else
            p++;
        }
        int[] a=new int[list.size()];
        for(int i=0;i<a.length;i++){
            a[i]=list.get(i);
        }
        return a;
    }
}