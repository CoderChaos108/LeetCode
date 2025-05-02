class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> ans=new ArrayList<Integer>();
        Arrays.sort(nums);
        int f=0;
        for(int i=0;i<nums.length;i++){
            f++;
            if(i==nums.length-1||nums[i+1]!=nums[i]){
                if((double)f>(double)(nums.length/3))
                ans.add(nums[i]);
                if(ans.size()==2)
                return ans;
                f=0;
            }

        }
        return ans;
    }
}