class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] arr={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashMap<Character,String> hm=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            hm.put((char)('a'+i),arr[i]);
        }
        StringBuilder sb=new StringBuilder();
        HashSet<String> set=new HashSet<>();
        for(String s:words){
            sb.setLength(0);
            for(int i=0;i<s.length();i++){
                sb.append(hm.get(s.charAt(i)));
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}