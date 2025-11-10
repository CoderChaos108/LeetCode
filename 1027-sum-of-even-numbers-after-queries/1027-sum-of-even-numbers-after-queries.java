class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int s=0;
        for(int i:nums){
            if(i%2==0)
            s=s+i;
        }   
        int[] ans=new int[queries.length];
        int itr=0;
        for(int[] a:queries){
            int val=a[0];
            int i=a[1];
            int x=nums[i];
            if(x%2==0)
            s=s-x;
            if((x+val)%2==0)
            s=s+x+val;
            ans[itr++]=s;
            nums[i]=x+val;
        }
        return ans;
    }
}