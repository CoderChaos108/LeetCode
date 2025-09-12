class Solution {
    public boolean doesAliceWin(String s) {
        Set<Character> vowels=Set.of('a','e','i','o','u');
        int n=s.length();
        for(int i=0;i<n;i++){
            if(vowels.contains(s.charAt(i)))
            return true;
        }
        return false;
    }
}