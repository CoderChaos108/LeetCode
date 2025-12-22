class Solution {
    List<String>[] dict=new ArrayList[26];
    int n;
    String s;
    boolean[] seen;
    public boolean search(int i){
        if(i==n)
        return true;
        if(seen[i])
        return false;
        seen[i]=true;
        for(String word:dict[s.charAt(i)-'a']){
            if(i+word.length()>n)
            continue;
            boolean check=true;
            for(int j=0;j<word.length();j++){
                if(s.charAt(i+j)!=word.charAt(j)){
                    check=false;
                    break;
                }
            }
            if(check){
                if(search(i+word.length()))
                return true;
            }
        }
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        this.s=s;
        n=s.length();
        seen=new boolean[n];
        for(int i=0;i<26;i++){
            dict[i]=new ArrayList<>();
        }
        for(String word:wordDict)
        dict[word.charAt(0)-'a'].add(word);
        return search(0);
    }
}