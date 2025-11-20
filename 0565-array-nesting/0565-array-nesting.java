class Solution {
    public int arrayNesting(int[] nums) {
       boolean[] seen=new boolean[nums.length];
       int ans=0;
       int len=nums.length;
        for(int i=0;i<len;i++){
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