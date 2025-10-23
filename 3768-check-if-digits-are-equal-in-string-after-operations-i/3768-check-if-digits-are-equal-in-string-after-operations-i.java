class Solution {
    public boolean recur(String s){
        if(s.length()==2){
            if(s.charAt(0)==s.charAt(1))
            return true;
            return false;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length()-1;i++){
            int val=((s.charAt(i)-'0')+(s.charAt(i+1)-'0'))%10;
            sb.append((char)(val+'0'));
        }
        return recur(sb.toString());
    }
    public boolean hasSameDigits(String s) {
        return recur(s);
    }
}