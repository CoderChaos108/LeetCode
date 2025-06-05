class Solution {
    public int maxRotateFunction(int[] nums) {
        int m=0;
        int s=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            s=s+nums[i];
            m=m+i*nums[i];
        }
        int t=n-1;
        int f=m;
        for(int i=1;i<n;i++){
            f=f+s-(n*nums[t]);
            t--;
            if(f>m)
            m=f;
        }
        return m;
    }
}