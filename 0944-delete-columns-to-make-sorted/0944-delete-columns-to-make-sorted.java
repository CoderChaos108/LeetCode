class Solution {
    public int minDeletionSize(String[] strs) {
        int ans=0;
        char last='a';
        for(int i=0;i<strs[0].length();i++){
            last='a';
            for(String s:strs){
                char c=s.charAt(i);
                if(c<last){
                    ans++;
                    break;
                }
                last=c;
            }
        }
        return ans;
    }
}