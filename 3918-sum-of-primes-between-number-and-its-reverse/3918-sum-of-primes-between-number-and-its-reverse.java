class Solution {
    public int sumOfPrimesInRange(int n) {
        int r=0;
        int t=n;
        int ans=0;
        while(t!=0){
            r=r*10+t%10;
            t=t/10;
        }
        int l=Math.min(n,r);
         r=Math.max(r,n);
        boolean[] prime=new boolean[r+1];
        Arrays.fill(prime,true);
         prime[0]=false;
        prime[1]=false;
        for(int i=2;i*i<=r;i++){
            for(int j=2*i;j<=r;j=j+i){
                prime[j]=false;
            }
        }
        for(int i=l;i<=r;i++){
            if(prime[i])
            ans=ans+i;
        }
        return ans;
    }
}