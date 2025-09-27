class Solution {
    int[] stock=new int[26];
    int ans=0;
    int[] a;
    HashMap<String,Integer> hm=new HashMap<>();
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
                find(i+1,currScore+hm.get(word));
                add(word);
            }
            find(i+1,currScore);
        }
    }
    public int maxScoreWords(String[] words2, char[] letters, int[] score) {
        for(String s:words2){
            int val=0;
            for(int i=0;i<s.length();i++){
                val=val+score[s.charAt(i)-'a'];
            }
            hm.put(s,val);
        }
        Arrays.sort(words2,(a,b)->{
            return hm.get(b)-hm.get(a);
        });
        words=words2;
        a=score;
        for(char c:letters){
            stock[c-'a']++;
        }
        find(0,0);
        return ans;
    }
}