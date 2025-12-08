class Solution {
    public int countTriples(int n) {
        int ans=0;
        for(int i=1;i<=n;i++){
            for(int j=i+1;j<=n;j++){
                double c=Math.sqrt(i*i+j*j);
                if(c>n)
                break;
                if(c%1==0.0)
                ans++;
            }
        }
        return ans*2;
    }
}