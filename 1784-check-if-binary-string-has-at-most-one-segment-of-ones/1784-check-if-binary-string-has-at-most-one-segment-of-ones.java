class Solution {
    public boolean checkOnesSegment(String s) {
        int l=0;
        while(l<s.length()&&s.charAt(l)=='1')
        l++;
        while(l<s.length()){
            if(s.charAt(l)=='1')
            return false;
            l++;
        }
        return true;
    }
}