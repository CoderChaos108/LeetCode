class Solution {
    
    public int bagOfTokensScore(int[] tokens, int power) {
        int s=0;
        Arrays.sort(tokens);
        int l=0;
        int n=tokens.length;
        int r=n-1;
        int ans=0;
        while(l<=r){
            int need=tokens[l];
            int buff=tokens[r];
            if(power<need){
                if(s==0)
                break;
                s--;
                power=power+buff;
                r--;
            }
            else{
                s++;
                ans=Math.max(ans,s);
                l++;
                power=power-need;
            }
        }
        return ans;
    }
}