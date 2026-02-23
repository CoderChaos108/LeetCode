class Solution {
    HashSet<String> set=new HashSet<>();
    public void enumerate(StringBuilder sb,int k){
        if(sb.length()==k){
            set.add(sb.toString());
            return;
        }
        sb.append('0');
        enumerate(sb,k);
        sb.setLength(sb.length()-1);
        sb.append('1');
        enumerate(sb,k);
        sb.setLength(sb.length()-1);
    }
    public boolean hasAllCodes(String s, int k) {
            enumerate(new StringBuilder(),k);
            int l=0;
            int r=k;
            while(r<=s.length()){
                String str=s.substring(l,r);
                l++;
                r++;
                if(set.contains(str))
                set.remove(str);
            }
            return set.size()==0;
    }
}