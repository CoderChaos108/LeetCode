class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        int l=words.length;
        int l2=0;
        String s="";
        for(int i=0;i<l;i++){
            s=words[i];
            l2=s.length();
            for(int j=0;j<l2;j++){
                if(s.charAt(j)==x){
                list.add(i);
                break;
                }
            }
        }
        return list;
    }
}