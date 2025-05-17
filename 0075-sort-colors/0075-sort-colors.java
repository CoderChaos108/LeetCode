class Solution {
    public void sortColors(int[] nums) {
        int z=0;
        int o=0;
        int t=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
            z++;
            if(nums[i]==1)
            o++;
            if(nums[i]==2)
            t++;
        }
        int k=0;
        while(z!=0){
            nums[k]=0;
            k++;
            z--;
        }
        while(o!=0){
            nums[k]=1;
            k++;
            o--;
        }
        while(t!=0){
            nums[k]=2;
            k++;
            t--;
        }
        
    }
}