class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int p=0;
        int[] a=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i==nums.length-1)
            p=0;
            else
            p=i+1;
            while(i!=-1){
                if(nums[p]>nums[i]){
                a[i]=nums[p];
                break;
                }
                if(p==i){
                    a[i]=-1;
                    break;
                }
                if(p==nums.length-1)
                p=0;
                else
                p++;
            }
        }
        return a;
    }
}