class Solution {
    public int maxDistance(int[] colors) {
        int ans=0;
        int n=colors.length;
        for(int i=0;i<colors.length;i++){
            if(colors[i]!=colors[0]){
                ans=Math.max(ans,i);
            }
            if(colors[i]!=colors[n-1]){
                ans=Math.max(ans,n-1-i);
            }
        }
        return ans;
    }
}