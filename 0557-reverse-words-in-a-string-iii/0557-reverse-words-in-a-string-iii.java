class Solution {
    public String reverseWords(String str) {
        String[] a=str.split(" ");
        StringBuilder sb=new StringBuilder();
        for(String s:a){
            for(int i=s.length()-1;i>=0;i--){
                sb.append(s.charAt(i));
            }
            sb.append(" ");
        }
        return sb.toString().substring(0,sb.length()-1);
    }
}