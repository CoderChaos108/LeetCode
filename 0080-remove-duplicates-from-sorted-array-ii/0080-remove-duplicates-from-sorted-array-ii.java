class Solution {
    public int removeDuplicates(int[] nums) {
        int x=0;
        int t=1;
         for(int i=0;i<nums.length;i++){
            t=1;
            while(i!=nums.length-1&&nums[i+1]==nums[i]){
                i++;
                if(t<2)
                t++;
            }
            for(int j=0;j<t;j++){
                nums[x]=nums[i];
                x++;
            }
         }
         return x;
    }
}