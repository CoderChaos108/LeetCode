class Solution {
    public int countPartitions(int[] nums) {
        int[] pre=new int[nums.length];
        int[] post=new int[nums.length];
        int s=0;
        for(int i=0;i<nums.length;i++){
            s=s+nums[i];
            pre[i]=s;
        }
        s=0;
        for(int i=nums.length-1;i>=0;i--){
            post[i]=s;
            s=s+nums[i];
        }
        int ans=0;
        for(int i=0;i<nums.length-1;i++){
            if((post[i]-pre[i])%2==0)
            ans++;
        }
        return ans;
    }
}