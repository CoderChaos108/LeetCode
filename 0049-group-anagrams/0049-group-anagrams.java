class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hm=new HashMap<>();
        ArrayList<List<String>> list=new ArrayList<>();
        for(String s:strs){
            char[] c=s.toCharArray();
            Arrays.sort(c);
            StringBuilder sb=new StringBuilder();
            for(char ch:c)sb.append(ch);
            String t=sb.toString();
            if(!hm.containsKey(t)){
                ArrayList<String> temp=new ArrayList<>();
                temp.add(s);
                hm.put(t,temp);
            }else{
                hm.get(t).add(s);
            }
        }
        for(String s:hm.keySet())list.add(hm.get(s));
        return list;
    }
}
