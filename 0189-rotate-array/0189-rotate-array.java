class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        int[] aux=new int[nums.length-k];
        int x=0;
        for(int i=0;i<nums.length-k;i++){
            aux[i]=nums[i];
        }
        for(int i=nums.length-k;i<nums.length;i++){
            nums[x]=nums[i];
            x++;
        }
        for(int i:aux){
            nums[x]=i;
            x++;
        }
    }
}