class Solution {
    public int bulbSwitch(int n) {
       long k=1;
       int ans=0;
       while(k*k<=n){
        ans++;
        k++;
       }
       return ans;
    }
}