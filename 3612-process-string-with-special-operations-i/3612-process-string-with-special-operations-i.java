class Solution {
    public String reverse(String s){
        StringBuilder sb=new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    public String processStr(String s) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isLowerCase(c)){
                sb.append(c);
            }
            else{
                if(c=='*')
                sb.setLength(Math.max(0,sb.length()-1));
                else if(c=='#')
                sb.append(sb.toString());
                else{
                    String t=reverse(sb.toString());
                    sb.setLength(0);
                    sb.append(t);
                }
            }
        }
        return sb.toString();
    }
}