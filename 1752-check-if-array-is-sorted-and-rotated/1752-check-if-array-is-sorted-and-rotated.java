class Solution {
    public boolean check(int[] nums) {
        int[] a=nums.clone();
        Arrays.sort(a);
        for(int k=0;k<nums.length;k++){
            int[] b=new int[a.length];
            int idx=0;
            for(int i=k;i<nums.length;i++)
            b[idx++]=nums[i];
            for(int i=0;i<k;i++)
            b[idx++]=nums[i];
            boolean same=true;
            for(int i=0;i<a.length;i++){
                if(a[i]!=b[i]){
                    same=false;
                    break;
                }
            }
            if(same)
            return same;
        }
        return false;
    }
}