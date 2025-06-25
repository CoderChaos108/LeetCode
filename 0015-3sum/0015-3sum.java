class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans=new HashSet<>();
        int len=nums.length;
        int l=0;
        int r=0;
        for(int i=0;i<len-2;i++){
            l=i+1;
            r=len-1;
            while(l<r){
             if(nums[l]+nums[r]==-nums[i]){
                
                List<Integer> list=new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[l]);
                list.add(nums[r]);
                Collections.sort(list);
                ans.add(list);
                l++;
                r--;
             }
             else if(nums[l]+nums[r]<-nums[i]) {
                l++;
             }  
             else{
                r--;
             }
            }
        }
        return new ArrayList<>(ans);
    }
}