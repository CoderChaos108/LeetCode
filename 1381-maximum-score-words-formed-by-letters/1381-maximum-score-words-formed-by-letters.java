class Solution {
    int[] stock=new int[26];
    int ans=0;
    int[] a;
    public boolean cost(String s){
        for(int i=0;i<s.length();i++){
            if(--stock[s.charAt(i)-'a']<0){
                for(int j=i;j>=0;j--){
                    stock[s.charAt(j)-'a']++;
                }
                return false;
            }
        }
        return true;
    }
    public void add(String s){
        for(int i=0;i<s.length();i++){
            stock[s.charAt(i)-'a']++;
        }
    }
    String[] words;
    boolean[] seen;
    public void find(int k,int currScore){
        if(k>=words.length){
            ans=Math.max(ans,currScore);
            return;
        }
        for(int i=k;i<words.length;i++){
            String word=words[i];
            if(cost(word)){
                find(i+1,currScore+a[i]);
                add(word);
            }
            find(i+1,currScore);
        }
    }
    public int maxScoreWords(String[] words2, char[] letters, int[] score) {
        a=new int[words2.length];
        for(int j=0;j<words2.length;j++){
            int val=0;
            for(int i=0;i<words2[j].length();i++){
                val=val+score[words2[j].charAt(i)-'a'];
            }
            a[j]=val;
        }
        words=words2;
        for(char c:letters){
            stock[c-'a']++;
        }
        find(0,0);
        return ans;
    }
}