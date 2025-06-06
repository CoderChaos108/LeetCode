class Solution {
    public boolean wordPattern(String p, String s) {
        String[] a=s.split(" ");
        if(a.length!=p.length())
        return false;
        HashMap<Character,String> hm=new HashMap<>();
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<p.length();i++){
            if(!hm.containsKey(p.charAt(i))){
                if(set.contains(a[i]))
                return false;
                hm.put(p.charAt(i),a[i]);
                set.add(a[i]);
            }
            else{
                if(!hm.get(p.charAt(i)).equals(a[i]))
                return false;
            }
        }
        return true;
    }
}