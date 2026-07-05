class Solution {
    int mod=1000000007;
    public int find(int[] a,int k){
        int n=a.length;
        int l=0;
        int s=0;
        int max=Integer.MIN_VALUE;
        for(int r=0;r<n;r++){
            if(a[r]%k==0)
            s=s+a[r];
            else
            s=s-a[r];
            max=Math.max(s,max);
            while(s<0){
                if(a[l]%k!=0)
                s=s+a[l];
                else
                s=s-a[l];
                l++;
                max=Math.max(s,max);
            }
        }
        while(l<n){
            if(a[l]%k!=0)
                s=s+a[l];
                else
                s=s-a[l];
                l++;
                max=Math.max(s,max);
        }
        if(max==0){
            max=Integer.MIN_VALUE;
            for(int i:a){
                int v=i;
                if(i%k!=0)
                v=-v;
                max=Math.max(max,v);
            }
        }
        return max;
    }
    public int divisibleGame(int[] nums) {
        int lim=0;
        for(int i:nums)
            lim=Math.max(lim,i);
        lim=Math.max(lim,2);
        boolean[] notPrime=new boolean[lim+1];
        
       for(int i=2;i*i<=lim;i++){
    if(notPrime[i]) continue;
    for(int j=i*i;j<=lim;j+=i){
        notPrime[j]=true;
    }
}
        long ans=Long.MIN_VALUE;
        long p=Long.MIN_VALUE;
        for(int k=2;k<=Math.max(lim,2);k++){
            if(notPrime[k])
                continue;
            long curr=find(nums,k);
            if(curr>p){
                ans=curr*k;
                ans=ans%mod;
                p=curr;
            }
        }
        
        return (int)(((ans%mod)+mod)%mod);
    }
}