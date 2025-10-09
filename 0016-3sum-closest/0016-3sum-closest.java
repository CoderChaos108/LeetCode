class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){
        int newTarget=target-nums[i];
        int l=i+1;
        int r=nums.length-1;
        while(l<r){
            int sum=nums[l]+nums[r];
            if(newTarget==sum)
            return sum+nums[i];
            else if(newTarget>sum)
            l++;
            else
            r--;
            if(Math.abs(target-ans)>Math.abs(target-(sum+nums[i])))
            ans=sum+nums[i];
        }
        }
        return ans;
    }
}