class Solution {
    public String longestWord(String[] words) {
        HashSet<String> set=new HashSet<>();
        Arrays.sort(words);
        int l=0;
        ArrayList<String> list=new ArrayList<>();
        for(String s:words){
            if(s.length()==1||set.contains(s.substring(0,s.length()-1))){
                set.add(s);
                if(s.length()>l){
                    l=s.length();
                    list.add(s);
                }
            }
        }
        if(list.size()==0)
        return "";
        return list.get(list.size()-1);
    }
}