class Solution {
    public long minimumSteps(String s) {
        long ans=0;
        int n=s.length();
        int j=n-1;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='1'){
                ans=ans+j-i;
                j--;
            }
        }
        return ans;
    }
}