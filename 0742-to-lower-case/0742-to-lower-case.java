class Solution {
    public String toLowerCase(String s) {
        StringBuilder sb=new StringBuilder();
        int l=s.length();
        char c;
       for(int i=0;i<l;i++){
        c=s.charAt(i);
        if(c>=65&&c<=90){
            sb.append((char)(c+32));
        }
        else
        sb.append(c);
       }
       return sb.toString();
    }
}