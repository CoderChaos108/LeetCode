class Solution {
    public int thirdMax(int[] oldnums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i:oldnums)
        set.add(i);
        int[] nums=new int[set.size()];
        int idx=0;
        for(int i:set){
            nums[idx]=i;
            idx++;
        }
        int l=nums.length-1;
        int t=0;
        int x=0;
        int temp=0;
        if(nums.length>=3)
        t=3;
        else
        t=1;
        for(int k=0;k<t;k++){
            x=0;
        for(int i=0;i<=l;i++){
            if(nums[i]>nums[x])
            x=i;
        }
        temp=nums[l];
        nums[l]=nums[x];
        nums[x]=temp;
        l--;
    }
    return nums[l+1];
    }
}