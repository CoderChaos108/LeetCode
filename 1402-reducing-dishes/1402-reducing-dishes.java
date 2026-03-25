class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int s=0;
        Arrays.sort(satisfaction);
        int itr=-1;
        for(int i=0;i<satisfaction.length;i++){
            if(satisfaction[i]>=0)
            {
                itr=i;
                break;
            }
        }
         if(itr==-1)
        return 0;
        for(int i=itr;i<satisfaction.length;i++){
            s=s+satisfaction[i];
        }
       
        int ans=0;
        int j=1;
        for(int i=itr;i<satisfaction.length;i++){
            ans=ans+(j++)*satisfaction[i];
        }
        itr--;
        int res=ans;
        while(itr>=0){
            s=s+satisfaction[itr];
            ans=ans+s;
            res=Math.max(ans,res);
            itr--;
        }
        return res;
    }
}