class Solution {
    public int largestInteger(int[] nums, int k) {
        int ans=-1;
        int n=nums.length;
        if(n==k){
            Arrays.sort(nums);
            return nums[n-1];
        }
        if(k==1){
            ans=-1;
            for(int i=0;i<n;i++){
                boolean res=true;
                for(int j=0;j<n;j++){
                    if(nums[i]==nums[j]&&i!=j)
                    res=false;

                }
                if(res)
                ans=Math.max(ans,nums[i]);
            }
            return ans;
        }
        ans=nums[0];
        int a1=nums[0];
        int a2=nums[n-1];
      for(int i=1;i<n;i++){
        if(nums[i]==a1){
            a1=-1;
            break;
        }
      }
      for(int i=0;i<n-1;i++){
        if(nums[i]==a2){
            a2=-1;
            break;
        }
      }
      return Math.max(a1,a2);
    }
}