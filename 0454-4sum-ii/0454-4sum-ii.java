class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int ans=0;
        for(int k:nums3){
            for(int l:nums4){
                hm.put(l+k,hm.getOrDefault(k+l,0)+1);
            }
        }
        for(int i:nums1){
            for(int j:nums2){
                int s=-i-j;
                if(hm.containsKey(s))
                ans=ans+hm.get(s);
            }
        }
        return ans;
    }
}