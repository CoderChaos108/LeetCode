class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] a=new int[100];
        int max=0;
        for(int i:nums){
        a[i-1]++;
        max=Math.max(max,a[i-1]);
        }
        int count=0;
        for(int i:a){
            if(i==max)
            count++;
        }
        return count*max;
    }
}