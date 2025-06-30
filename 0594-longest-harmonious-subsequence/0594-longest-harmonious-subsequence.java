class Solution {
    public int findLHS(int[] nums) {
        int l=0;
        for(int i=0;i<nums.length-l;i++){
            int u=0;
            int d=0;
            int s=0;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]==nums[i])
                s++;
                else if(nums[j]==nums[i]+1)
                u++;
                else if(nums[j]==nums[i]-1)
                d++;
            }
            if(u==0&&d==0)
            continue;
            s=s+Math.max(u,d)+1;
            l=Math.max(l,s);
        }
        return l;
    }
}