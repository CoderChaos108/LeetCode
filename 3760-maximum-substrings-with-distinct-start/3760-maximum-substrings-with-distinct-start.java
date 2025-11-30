class Solution {
    public int maxDistinct(String s) {
        int ans=0;
        boolean[] seen=new boolean[26];
        for(int i=0;i<s.length();i++){
            if(!seen[s.charAt(i)-'a'])
            ans++;
            seen[s.charAt(i)-'a']=true;
        }
        return ans;
    }
}