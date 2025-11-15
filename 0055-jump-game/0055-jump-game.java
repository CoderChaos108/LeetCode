class Solution {
    boolean[] seen;
    int[] nums;
    boolean found=false;
    int n;
    public void jump(int k){
        if(k>=seen.length)
        return;
        if(k==seen.length-1){
        found=true;
        return;
        }
        if(found)
        return;
        seen[k]=true;
        int lim=nums[k];
        for(int i=1;i<=lim;i++){
            if(k+i>=n)
            return;
            if(!seen[k+i])
            jump(k+i);
        }
    }
    public boolean canJump(int[] nums) {
        seen=new boolean[nums.length];
        this.nums=nums;
        n=nums.length;
        jump(0);
        return found;
    }
}