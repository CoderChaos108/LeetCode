class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0){
            return new int[] {-1,-1};
        }
        int l=0;
        int r=nums.length-1;
        int m;
        while(l>-1){
            if(r-l==0){
                if(nums[l]==target){
                l=0;
                r=0;
                }
                else{
                    l=-1;
                    r=-1;
                }
                break;
            }
            else if(r-l==1){
                if(nums[l]==target&&nums[r]==target){
                    l=l;
                    r=r;
                }
                else if(nums[l]==target&&nums[r]!=target){
                    l=l;
                    r=l;
                }
                else if(nums[l]!=target&&nums[r]==target){
                    l=r;
                    r=r;
                }
                else{
                    l=-1;
                    r=-1;
                }
            break;
            }
            m=(l+r)/2;
            if(nums[m]==target){
                l=m;
                r=m;
                while(l-1>=0&&nums[l-1]==target)
                l--;
                while(r+1<nums.length&&nums[r+1]==target)
                r++;
                break;
            }
            else if(nums[m]<target)
            l=m;
            else if(nums[m]>target)
            r=m;
        }
        return new int[] {l,r};
    }
}