class Solution {
    public void moveZeroes(int[] nums) {
        int a[]=new int[nums.length];
        int x=0;
        for(int i:nums){
            if(i!=0){
                a[x]=i;
                x++;
            }
        }
        for(int i=x;i<a.length;i++){
            a[i]=0;
        }
        for(int i=0;i<a.length;i++){
            nums[i]=a[i];
        }
    }
}