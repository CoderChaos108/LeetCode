class Solution {
    public boolean isValid(String word) {
        if(word.length()<3)
        return false;
        boolean vowel=false;
        boolean cons=false;
        Set<Character> set=Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        for(int i=0;i<word.length();i++){
            if(vowel&&cons)
            break;
            char c=word.charAt(i);
            if(!Character.isLetter(c)&&!Character.isDigit(c))
            return false;
            if(!vowel&&set.contains(c)){
            vowel=true;
            continue;
            }
            if(!cons&&!Character.isDigit(c)&&!set.contains(c))
            cons=true;
        }
        return (vowel&&cons);
    }
}