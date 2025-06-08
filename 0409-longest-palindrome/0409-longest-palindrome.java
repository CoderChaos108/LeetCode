class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> hm=new HashMap<>();
        int c=0;
        for(int i=0;i<s.length();i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
            if(hm.get(s.charAt(i))%2==0)
            c=c+2;
        }
        for(int i:hm.values()){
            if(i%2!=0){
                c++;
                break;
            }
        }
        return c;
    }
}