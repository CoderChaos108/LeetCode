class Solution {
    public String reverseVowels(String s) {
        int l = 0;
        int r = s.length() - 1;
        StringBuilder sb = new StringBuilder(s);

        while (l < r) {
            char leftChar = sb.charAt(l);
            char rightChar = sb.charAt(r);
            boolean isLeftVowel = isVowel(leftChar);
            boolean isRightVowel = isVowel(rightChar);

            if (!isLeftVowel) {
                l++;
            } else if (!isRightVowel) {
                r--;
            } else {
                sb.setCharAt(l, rightChar);
                sb.setCharAt(r, leftChar);
                l++;
                r--;
            }
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
