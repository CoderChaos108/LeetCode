class Solution {
    public String stringHash(String s, int k) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i=i+k){
            int val=0;
            for(int j=i;j<i+k;j++){
                val=val+(s.charAt(j)-'a');
                val=val%26;
            }
            val=(int)'a'+val;
            sb.append((char)(val));
        }
        return sb.toString();
    }
}