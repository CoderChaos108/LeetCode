class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int l=0;
        int r=0;
        HashSet<List<Integer>> ans=new HashSet<>(); 
        for(int i=0;i<nums.length-3;i++){
            for(int j=i+1;j<nums.length-2;j++){
                l=j+1;
                r=nums.length-1;
                int neotarget=target-nums[i]-nums[j];
                while(l<r){
                    if(neotarget>nums[l]+nums[r])
                    l++;
                    else if(neotarget<nums[l]+nums[r])
                    r--;
                    else{
                        ArrayList<Integer> list=new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        ans.add(list);
                        l++;
                        r--;
                        continue;
                    }
                }
            }
        }
        return new ArrayList<>(ans);
    }
}