class Solution {
    int ans=0;
    boolean[] seen;
    int[] nums;
    public void dfs(int i,int c){
        if(seen[i])
        return;
        ans=Math.max(ans,c);
        seen[i]=true;
        dfs(nums[i],c+1);
    }
    public int arrayNesting(int[] nums) {
        this.nums=nums;
        seen=new boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            dfs(i,1);
        }
        return ans;
    }
}