class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap <String,List<String>> hm=new HashMap<>();
        ArrayList<List<String>> list=new ArrayList<List<String>>();
        String t;
        char[] c;
        for(String s:strs){
            c=s.toCharArray();
            Arrays.sort(c);
            t=new String(c);
            ArrayList<String> temp=new ArrayList<String> ();
            if(!hm.containsKey(t)){
            temp.add(s);
            hm.put(t,temp);
            }
            else{
                hm.get(t).add(s);
            }
        }
        for(String s:hm.keySet()){
            list.add(hm.get(s));
        }
        return list;
    }
}