class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set=new HashSet<>();
        HashSet<String> ans=new HashSet<>();
        int l=s.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<=l-10;i++){
            sb.setLength(0);
            sb.append(s.substring(i,i+10));
            if(!set.add(sb.toString()))
            ans.add(sb.toString());
        }
        return new ArrayList<>(ans);
    }
}