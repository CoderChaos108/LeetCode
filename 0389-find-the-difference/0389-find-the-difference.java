class Solution {
    public char findTheDifference(String s, String t) {
        int si=0;
        int ti=0;
        int lt=t.length();
        int ls=s.length();
        for(int i=0;i<ls;i++){
            si=si+((int)s.charAt(i));
        }
        for(int i=0;i<lt;i++){
            ti=ti+(int)t.charAt(i);
        }
        return (char)(ti-si);
    }
}