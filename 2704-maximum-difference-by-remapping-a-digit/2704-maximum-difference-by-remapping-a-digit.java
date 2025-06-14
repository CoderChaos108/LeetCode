class Solution {
    public int minMaxDifference(int num) {
        int l=0;
        int sm=0;
        String s=String.valueOf(num);
        char lc=',';
        char sc=s.charAt(0);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='9'){
                lc=s.charAt(i);
                break;
            }
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==lc)
            l=10*l+9;
            else
            l=10*l+s.charAt(i)-'0';
            if(s.charAt(i)==sc)
            sm=sm*10;
            else
            sm=10*sm+s.charAt(i)-'0';

        }
        return l-sm;
    }
}