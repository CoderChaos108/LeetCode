class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int l=0;
          ArrayList<Integer> ans=new ArrayList<Integer>();
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>l)
            l=nums[i];
        }
        int[] a=new int[l+1];
        for(int i=0;i<nums.length;i++){
            a[nums[i]]++;
        }
      
        for(int i=0;i<a.length;i++){
            if(a[i]>1)
            ans.add(i);
        }
        return ans;
    }
}