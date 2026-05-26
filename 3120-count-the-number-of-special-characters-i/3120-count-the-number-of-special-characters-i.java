class Solution {
    public int numberOfSpecialChars(String word) {
        HashSet<Character>  set=new HashSet<>();
        HashSet<Character>  seen=new HashSet<>();
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(Character.isUpperCase(c))
            set.add(c);
        }
        int ans=0;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(Character.isUpperCase(c))
            continue;
            if(!seen.add(c))
            continue;
            char uc=Character.toUpperCase(c);
            if(set.contains(uc))
            ans++;
        }
        return ans;
    }
}