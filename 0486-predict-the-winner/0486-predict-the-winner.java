class Solution {
    int[] nums;
    public boolean find(int l,int r,int a,int b,boolean turnA){
        if(l>r){
            if(a>=b)
            return true;
            return false;
        }
        if(turnA){
            boolean flag=find(l+1,r,a+nums[l],b,false);
            if(flag)
            return true;
            return find(l,r-1,a+nums[r],b,false);
        }
        else{
            boolean flag=find(l+1,r,a,b+nums[l],true);
            if(!flag)
            return false;
            return find(l,r-1,a,b+nums[r],true);
        }
    }
    public boolean predictTheWinner(int[] nums) {
        this.nums=nums;
        return find(0,nums.length-1,0,0,true);
    }
}