class Solution {
    public int minimumPushes(String word) {
        
       int ans=0;
        for(int j=0;j<word.length();j++){
            int push=j/8+1;
            ans=ans+push;

        }    
        return ans;
    }
}