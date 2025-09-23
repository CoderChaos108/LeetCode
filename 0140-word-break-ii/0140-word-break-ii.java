class Solution {
    List<String>[] dict;
    List<String> ans=new ArrayList<>();
    String s;
    public void find(StringBuilder sb,int k){
        if(k==s.length()){
            ans.add(sb.toString().substring(0,sb.length()-1));
            return;
        }
        char c=s.charAt(k);
        for(String word:dict[c-'a']){
            int l=word.length();
            if(k+l>s.length())
            continue;
            boolean match=true;
            for(int i=0;i<l;i++){
                if(word.charAt(i)!=s.charAt(k+i)){
                    match=false;
                    break;
                }
            }
            if(match){
                sb.append(word);
                sb.append(" ");
                find(sb,k+word.length());
                sb.setLength(sb.length()-word.length()-1);
            }
        }
    }
    public List<String> wordBreak(String s2, List<String> wordDict) {
        s=s2;
        dict=new ArrayList[26];
        for(int i=0;i<26;i++)
        dict[i]=new ArrayList<>();
        for(String str:wordDict){
            dict[str.charAt(0)-'a'].add(str);
        }
        find(new StringBuilder(),0);
        return ans;
    }
}