class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        int[] aux=new int[nums.length];
        int x=0;
        for(int i=nums.length-k;i<nums.length;i++){
            aux[x]=nums[i];
            x++;
        }
        for(int i=0;i<nums.length-k;i++){
            aux[x]=nums[i];
            x++;
        }
        for(int i=0;i<aux.length;i++)
        nums[i]=aux[i];
    }
}