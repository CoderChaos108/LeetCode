class Solution {
    public int minSteps(String s, String t) {         
        HashMap<Character,Integer> hm=new HashMap<>();
        int l=s.length();
        for(int i=0;i<l;i++){
            if(!hm.containsKey(s.charAt(i)))
            hm.put(s.charAt(i),1);
            else
            hm.put(s.charAt(i),hm.get(s.charAt(i))+1);
        }
        int c=0;
        l=t.length();
        for(int i=0;i<l;i++){
            if(hm.containsKey(t.charAt(i))){
            hm.put(t.charAt(i),hm.get(t.charAt(i))-1);
            if(hm.get(t.charAt(i))==0)
            hm.remove(t.charAt(i));
            }
            else
            c++;
        }
        for(int i:hm.values())
        c=c+i;
        return c;
    }
}