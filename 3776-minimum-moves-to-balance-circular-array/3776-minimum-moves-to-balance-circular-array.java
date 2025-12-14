class Solution {
    public long minMoves(int[] balance) {
        long ans=0;
        int k=0;
        for(int i=0;i<balance.length;i++){
            if(balance[i]<0){
                k=i;
                break;
            }
        }
        int l=k-1;
        int r=k+1;
        int cost=0;
        int m=balance[k];
        boolean[] seen=new boolean[balance.length];
        seen[k]=true;
        while(m<0){
            cost++;
            if(l==-1)
            l=balance.length-1;
            if(r==balance.length)
            r=0;
            if(seen[l]&&seen[r])
            return -1;
            long bal=0;
            if(!seen[l])
            bal=bal+balance[l];
            if(!seen[r])
            bal=bal+balance[r];
            seen[l]=true;
            seen[r]=true;
            if(l==r)
            bal=bal/2;
            if(l==k)
            bal=bal-balance[l];
            if(r==k)
            bal=bal-balance[r];
            ans=ans+Math.min(-(long)m*cost,bal*cost);
            if(-m<=bal)
            m=0;
            else
            m=m+(int)bal;
            l--;
            r++;
        }
        return ans;
    }
}