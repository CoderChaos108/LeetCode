class Solution {
    public String longestWord(String[] words) {
        HashSet<String> set=new HashSet<>();
        Arrays.sort(words);
        int l=0;
        ArrayList<String> list=new ArrayList<>();
        for(String s:words){
            if(s.length()==1||set.contains(s.substring(0,s.length()-1))){
                set.add(s);
                if(s.length()>=l){
                    l=s.length();
                    list.add(s);
                }
            }
        }
        
       for(int i=list.size()-1;i>=0;i--){
            if(i==0||list.get(i-1).length()<l)
            return list.get(i);
        }
        return "";
    }
}