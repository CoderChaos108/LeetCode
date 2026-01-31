class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        Arrays.sort(letters);
        char ans=letters[0];
        for(char c:letters){
            if(target<c)
            return c;
        }
        return ans;
    }
}