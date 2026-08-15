class Solution {
    public int longestSubsequence(int[] nums) {
    int z=0;
     int xor=0;
     for(int i:nums){
     xor=xor^i;
     if(i==0)
     z++;
     }
     if(z==nums.length)
     return 0;
     if(xor==0)
     return nums.length-1;
     return nums.length;   
    }
}