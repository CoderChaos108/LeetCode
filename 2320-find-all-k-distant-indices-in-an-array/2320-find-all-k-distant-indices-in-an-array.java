class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {     
        List<Integer> list=new ArrayList<Integer>();
        List<Integer> idx=new ArrayList<Integer>();
        int l=nums.length;
        for(int i=0;i<l;i++){
            if(nums[i]==key)
            idx.add(i);
        }
        for(int i=0;i<l;i++){
            for(int j:idx){
                if(Math.abs(i-j)<=k){
                    list.add(i);
                    break;
                }
            }
        }
        return list;
    }
}