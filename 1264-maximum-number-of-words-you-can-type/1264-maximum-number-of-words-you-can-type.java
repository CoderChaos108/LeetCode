class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] set=new boolean[26];
        for(int i=0;i<brokenLetters.length();i++){
            set[brokenLetters.charAt(i)-'a']=true;
        }
        String[] words=text.split(" ");
        int ans=0;
        for(String s:words){
            boolean broken=false;
            for(int i=0;i<s.length();i++){
                int alphabet=s.charAt(i)-'a';
                if(set[alphabet]){
                    broken=true;
                    break;
                }
            }
            if(!broken)
            ans++;
        }
        return ans;
    }
}