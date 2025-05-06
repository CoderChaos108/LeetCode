class Solution {
    static boolean vow(char c){
        c=Character.toLowerCase(c);
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
        return true;
        return false;
    }
    public String reverseVowels(String s) {
        char t='0';
        int l=0;
        int r=s.length()-1;
        StringBuilder sb=new StringBuilder(s);
        while(l<r){
            if(!vow(sb.charAt(l)))
            l++;
            if(!vow(sb.charAt(r)))
            r--;
            if(vow(sb.charAt(r))&&vow(sb.charAt(l))){
                t=sb.charAt(l);
                sb.setCharAt(l,sb.charAt(r));
                sb.setCharAt(r,t);
                l++;
                r--;
            }            
        }
        return sb.toString();
    }
}