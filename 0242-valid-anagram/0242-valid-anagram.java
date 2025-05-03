class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
        return false;
       HashMap<Character,Integer> hm= new HashMap<Character,Integer>();
       char c='1';
       for(int i=0;i<s.length();i++){
        c=s.charAt(i);
        if(!hm.containsKey(c))
        hm.put(c,1);
        else
        hm.put(c,hm.get(c)+1);
       }
        for(int i=0;i<s.length();i++){
            c=t.charAt(i);
            if(!hm.containsKey(c))
            return false;
            else{
                hm.put(c,hm.get(c)-1);
                if(hm.get(c)==0)
                hm.remove(c);
            }
        }      
        if(hm.size()==0)
        return true;
        return false;
    }
}