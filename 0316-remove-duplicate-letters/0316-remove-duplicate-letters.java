class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character,Integer> hm=new HashMap<>();
        StringBuilder sb=new StringBuilder();
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<s.length();i++)
        hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(set.contains(c)){
            hm.put(c,hm.get(c)-1);
            continue;
            }
            while(sb.length()>0&&sb.charAt(sb.length()-1)>=c&&hm.get(sb.charAt(sb.length()-1))!=0){
                set.remove(sb.charAt(sb.length()-1));
                sb.setLength(sb.length()-1);
            }   
            sb.append(c);
            set.add(c);
            hm.put(c,hm.get(c)-1);
        }
        return sb.toString();
    }
}