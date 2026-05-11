class Solution {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        StringBuilder proto=new StringBuilder();
        StringBuilder sb=new StringBuilder();
        for(String s:chunks)
        proto.append(s);
        HashMap<String,Integer> hm=new HashMap<>();
        for(int i=0;i<proto.length();i++){
            char c=proto.charAt(i);
            if(c==' '||(c=='-'&&(i==0||i==proto.length()-1||!Character.isLetter(proto.charAt(i-1))||!Character.isLetter(proto.charAt(i+1))))){
                if(sb.length()!=0){
                    String s=sb.toString();
                    hm.put(s,hm.getOrDefault(s,0)+1);
                    sb.setLength(0);
                }
            }
            else
            sb.append(c);
        }
         if(sb.length()!=0){
                    String s=sb.toString();
                    hm.put(s,hm.getOrDefault(s,0)+1);
                    sb.setLength(0);
                }
        int[] a=new int[queries.length];
        int itr=0;
        for(String q:queries)
        a[itr++]=hm.getOrDefault(q,0);
        return a;
    }
}