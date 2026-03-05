class Solution {
    public int maxProduct(String[] words) {
        HashSet[] map=new HashSet[words.length];
        for(int i=0;i<map.length;i++)
        map[i]=new HashSet<>();
        for(int i=0;i<words.length;i++){
            String word=words[i];
            HashSet<Character> set=map[i];
            for(int j=0;j<word.length();j++){
                set.add(word.charAt(j));
            }
        }
        int ans=0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                HashSet<Character> set1=map[i];
                HashSet<Character> set2=map[j];
                boolean common=false;
                for(int k=0;k<26;k++){
                    char c=(char)('a'+k);
                    if(set1.contains(c)&&set2.contains(c)){
                        common=true;
                        break;
                    }
                }
                if(!common){
                    ans=Math.max(ans,(words[i].length()*words[j].length()));
                }
            }
        }
        return ans;
    }
}