class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
        return false;
        int sl=0;
        int tl=0;
        for(int i=0;i<s.length();i++){
            sl=sl+s.charAt(i)*s.charAt(i)*s.charAt(i)*s.charAt(i);
            tl=tl+t.charAt(i)*t.charAt(i)*t.charAt(i)*t.charAt(i);
        }
           if(sl==tl)
           return true;
           return false;
    }
}