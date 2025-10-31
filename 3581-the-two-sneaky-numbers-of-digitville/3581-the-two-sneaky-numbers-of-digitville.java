class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n=nums.length-2;
        int[] a=new int[2];
        int idx=0;
        int[] set=new int[nums.length-2];
        for(int i:nums){
            if(++set[i]==2){
                a[idx]=i;
                if(++idx==2){
                    return a;
                }
            }
        }
        return a;
    }
}