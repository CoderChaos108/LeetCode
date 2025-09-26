class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                int s=nums[i]+nums[j];
                int l=j+1;
                int r=n-1;
                while(l<=r){
                int m=(l+r)/2;
                int val=nums[m];
                if(val>=s){
                    r=m-1;
                }
                else{
                    l=m+1;
                }
                }
                ans=ans+r-j;
            }
        }
        return ans;
    }
}