class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int ans=0;
        for(int i=0;i<s.length();i++){
            int c=0;
            StringBuilder sb=new StringBuilder();
            for(int j=i;j<s.length();j++){
                sb.append(s.charAt(j));
                if(j!=i){
                    if(sb.charAt(sb.length()-1)==sb.charAt(sb.length()-2))
                    c++;
                }
                if(c==2)
                break;
                ans=Math.max(ans,j-i+1);
            }
        }
        return ans;
    }
}