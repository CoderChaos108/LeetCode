class Solution {
    public int countOdds(int low, int high) {
        int ans=0;
        if(low%2==0)
        low++;
        for(int i=low;i<=high;i=i+2){
            ans++;
        }
        return ans;
    }
}