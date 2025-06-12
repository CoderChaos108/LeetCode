class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] arr={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        StringBuilder sb=new StringBuilder();
        HashSet<String> set=new HashSet<>();
        for(String s:words){
            sb.setLength(0);
            for(int i=0;i<s.length();i++){
                sb.append(arr[s.charAt(i)-'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}