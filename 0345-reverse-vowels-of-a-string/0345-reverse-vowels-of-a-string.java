class Solution {
    public String reverseVowels(String s) {
        char t='0';
        ArrayList <Integer> a=new ArrayList<Integer>();
        StringBuilder sb=new StringBuilder(s);
        for(int i=0;i<s.length();i++){
            t=Character.toLowerCase(s.charAt(i));
            if(t=='a'||t=='e'||t=='i'||t=='o'||t=='u')
            a.add(i);
        }
        for(int i=0;i<=a.size()/2-1;i++){
            t=sb.charAt(a.get(a.size()-i-1));
            sb.setCharAt(a.get(a.size()-i-1),sb.charAt(a.get(i)));
            sb.setCharAt(a.get(i),t);
        }
        return sb.toString();
    }
}