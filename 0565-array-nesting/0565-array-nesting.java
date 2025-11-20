class Solution {
    public int arrayNesting(int[] nums) {
       boolean[] seen=new boolean[nums.length];
       int ans=0;
        for(int i=0;i<nums.length;i++){
            int n=i;
            int c=0;
            while(!seen[n]){
                seen[n]=true;
                ans=Math.max(++c,ans);
                n=nums[n];
            }
        }
        return ans;
    }
}