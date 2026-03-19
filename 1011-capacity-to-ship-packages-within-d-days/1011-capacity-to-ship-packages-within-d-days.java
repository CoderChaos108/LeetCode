class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l=0;
        int w=0;
        for(int i:weights)
        w=w+i;
        int r=w;
        int ans=Integer.MAX_VALUE;
        while(l<=r){
            int m=(l+r)/2;
            int itr=0;
            for(int i=0;i<days&&itr<weights.length;i++){
                int s=0;
                while(itr<weights.length&&s+weights[itr]<=m){
                    s=s+weights[itr++];
                }
            }
            if(itr>=weights.length){
                ans=Math.min(ans,m);
                r=m-1;
            }
            else
            l=m+1;
        }

        return ans;
    }
}