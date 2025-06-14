class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n-3;i++){
            if(i>0&&nums[i]==nums[i-1])
            continue;
            for(int j=i+1;j<n-2;j++){
                if(j>i+1&&nums[j]==nums[j-1])
                continue;
                int l=j+1;
                int r=n-1;
                long neotarget=(long)target-(long)nums[i]-(long)nums[j];
                while(l<r){
                    long sum=(long)nums[l]+(long)nums[r];
                    if(sum<neotarget){
                        l++;
                    }
                    else if(sum>neotarget){
                        r--;
                    }
                    else{
                        List<Integer> list=new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        ans.add(list);
                        while(l<r&&nums[l]==nums[l+1])l++;
                        while(l<r&&nums[r]==nums[r-1])r--;
                        l++;
                        r--;
                    }
                }
            }
        }
        return ans;
    }
}
