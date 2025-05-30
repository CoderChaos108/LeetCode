class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String,Integer> hm=new HashMap<>();
        ArrayList<String> list=new ArrayList<>();
        int l=s.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<=l-10;i++){
            sb.setLength(0);
            sb.append(s.substring(i,i+10));
            hm.put(sb.toString(),hm.getOrDefault(sb.toString(),0)+1);
            if(hm.get(sb.toString())==2)
            list.add(sb.toString());
        }
        
        return list;
    }
}