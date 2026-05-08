class Solution {
    public int sumOfPrimesInRange(int n) {
        int r=0;
        int t=n;
        int ans=0;
        while(t!=0){
            r=r*10+t%10;
            t=t/10;
        }
        for(int i=Math.min(n,r);i<=Math.max(n,r);i++){
            boolean prime=true;
            if(i<2)
            continue;
            for(int j=2;j*j<=i;j++){
                if(i%j==0){
                    prime=false;
                    break;
                }
            }
            if(prime)
            ans=ans+i;
        }
        return ans;
    }
}