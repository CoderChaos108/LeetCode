class Solution {
    public List<String> printVertically(String s) {
        List<String> list=new ArrayList<>();
        String[] words=s.split(" ");
        int len=0;
        for(String w:words)
        len=Math.max(len,w.length());
        for(int i=0;i<len;i++){
            StringBuilder sb=new StringBuilder();
            int itr=0;
            for(String w:words){
                if(i>=w.length())
                sb.append(" ");
                else{
                sb.append(w.charAt(i));
                itr=sb.length()-1;
                }
            }
            
            sb.setLength(itr+1);
            list.add(sb.toString());
        }
        return list;
    }
}