class Solution {
    public int missingNumber(int[] nums) {
        int[] a=new int[nums.length+1];
        for(int i:nums){
            a[i]=1;
        }
        int l=0;
        int r=nums.length;
        int ml=(l+r)/2;
        int mr=ml;
        while(l!=-1){
            if(l<=nums.length&&a[l]==0)
            return l;
            if(ml>=0&&a[ml]==0)
            return ml;
            if(mr<=nums.length&&a[mr]==0)
            return mr;
            if(r>=0&&a[r]==0)
            return r;
            l++;
            ml--;
            mr++;
            r--;
        }
        return 0;
    }
}