class Solution {
    public boolean checkDivisibility(int n) {
        int s=0;
        int p=1;
        int t=n;
        while(t!=0){
            int d=t%10;
            if(d==0)
            p=0;
            t=t/10;
        }
        t=n;
        while(t!=0){
            int d=t%10;
            s=s+d;
            p=p*d;
            if(p>n)
            return false;
            t=t/10;
        }
        return n%(s+p)==0;
    }
}